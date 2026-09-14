<%@ include file="../calendar/view.jsp" %>

<div class="dashboard__event">
	<div class="dashboard__event-top">
		<h4>Acara Selanjutnya</h4>
		<a href="javascript:void(0)" class="btn__agency btn--sienna agency-self-center btn-reminder">
			<span class="position-relative order-10">
				<span class="text-14px agency-uppercase letter-spacing-1px mr-4px">Buat Pengingat</span>
				<svg class="w-16px-h-16px display-inline-block vertical-align-middle top-min-1px position-relative" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 16 16" fill="none">
					<path d="M12.8 7.99995L3.20005 7.99995M8.00005 12.8L8.00005 3.19995" stroke-width="2" stroke-linecap="round"/>
				</svg>
			</span>
		</a>
	</div>
	<div class="dashboard__event-bottom">	
		<% if (events.size() > 0) { %>
			<div class="card-event-wrapper">
				<% for (int i = 0; i < events.size(); i++) { %>
					<%-- <portlet:renderURL var="viewDetailURL">
					    <portlet:param name="mvcPath" value="/dashboard/calendar/detail.jsp" />
					    <portlet:param name="eventId" value="<%= String.valueOf(events.get(i).getAgentCalendarId()) %>" />
					    <portlet:param name="title" value="<%= events.get(i).getTitle().replace(" ", "-").toLowerCase() %>" />
					</portlet:renderURL> --%>
					<% String target = EncryptionHelper.encryptRandom(String.valueOf(events.get(i).getAgentCalendarId())); %>
					<% if (timestamp == (events.get(i).getStartDate().getTime() / 1000) || ((timestamp >= events.get(i).getStartDate().getTime() / 1000) && (Validator.isNotNull(events.get(i).getEndDate()) == true && timestamp <= events.get(i).getEndDate().getTime() / 1000))) { %>
						<div class="card-event" id="bg-sienna">
							<a href="<%= host %>/dashboard/event-detail/<%= target %>" class="card-event__header flex-justify-between link-event">
								<div class="card-date-time flex-justify-between gap-12px align-items-center">
									<div class="display-flex gap-8px">
										<svg class="icon-calendar" xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none">
											<path d="M3.67666 16.7742L2.87061 16.1824L2.87061 16.1824L3.67666 16.7742ZM4.903 13.1768L3.903 13.165V13.1768H4.903ZM4.92874 11.0018L5.92874 11.0137V11.0018H4.92874ZM20.3324 16.7917L21.15 16.216L21.15 16.216L20.3324 16.7917ZM19.1522 13.1768L18.1522 13.1644V13.1768H19.1522ZM19.1779 11.1096L20.1779 11.1221V11.1096H19.1779ZM9.79131 19.8966C9.35033 19.5641 8.7233 19.6521 8.3908 20.093C8.0583 20.534 8.14624 21.1611 8.58722 21.4936L9.79131 19.8966ZM15.4152 21.4936C15.8562 21.1611 15.9442 20.534 15.6117 20.093C15.2792 19.6521 14.6521 19.5641 14.2111 19.8966L15.4152 21.4936ZM2.07181 5.63229C1.8663 6.14492 2.11527 6.72708 2.6279 6.93259C3.14053 7.13809 3.72269 6.88912 3.92819 6.37649L2.07181 5.63229ZM6.64253 3.28029C7.12876 3.01837 7.31059 2.41187 7.04867 1.92565C6.78674 1.43942 6.18025 1.25759 5.69402 1.51952L6.64253 3.28029ZM18.293 1.53434C17.8096 1.26726 17.2012 1.44264 16.9341 1.92606C16.6671 2.40947 16.8424 3.01786 17.3258 3.28494L18.293 1.53434ZM20.0679 6.35675C20.2679 6.87154 20.8474 7.12672 21.3622 6.9267C21.877 6.72669 22.1321 6.14722 21.9321 5.63243L20.0679 6.35675ZM4.48271 17.3661C5.19348 16.3981 5.903 14.9487 5.903 13.1768H3.903C3.903 14.407 3.4079 15.4506 2.87061 16.1824L4.48271 17.3661ZM5.90293 13.1887L5.92867 11.0137L3.92881 10.99L3.90307 13.165L5.90293 13.1887ZM21.15 16.216C20.6353 15.485 20.1522 14.4291 20.1522 13.1768H18.1522C18.1522 14.9473 18.8321 16.3979 19.5147 17.3674L21.15 16.216ZM20.1521 13.1893L20.1778 11.122L18.178 11.0971L18.1522 13.1644L20.1521 13.1893ZM20.1779 11.1096C20.1779 6.48905 16.5488 2.68486 12.0012 2.68486V4.68486C15.3807 4.68486 18.1779 7.52901 18.1779 11.1096H20.1779ZM19.9029 18.7997C20.6648 18.7997 21.1248 18.2494 21.304 17.8139C21.4845 17.3752 21.523 16.7457 21.15 16.216L19.5147 17.3674C19.4555 17.2834 19.4401 17.2048 19.4376 17.1591C19.4351 17.1151 19.4428 17.0811 19.4544 17.0529C19.4655 17.0259 19.4935 16.9725 19.5612 16.9176C19.6359 16.8569 19.7557 16.7997 19.9029 16.7997V18.7997ZM5.92874 11.0018C5.92874 7.48076 8.67925 4.68486 12.0012 4.68486V2.68486C7.51116 2.68486 3.92874 6.4408 3.92874 11.0018H5.92874ZM4.10062 16.7997C4.25103 16.7997 4.37233 16.8592 4.44655 16.9206C4.51344 16.9759 4.53989 17.0287 4.54985 17.0537C4.56038 17.0801 4.5676 17.1125 4.56469 17.1558C4.56168 17.2008 4.54525 17.2809 4.48271 17.3661L2.87061 16.1824C2.48078 16.7133 2.51603 17.3532 2.69229 17.795C2.86688 18.2325 3.32603 18.7997 4.10062 18.7997V16.7997ZM19.9029 16.7997H4.10062V18.7997H19.9029V16.7997ZM12.0012 20.5999C11.13 20.5999 10.3577 20.3237 9.79131 19.8966L8.58722 21.4936C9.51332 22.1918 10.7119 22.5999 12.0012 22.5999V20.5999ZM14.2111 19.8966C13.6448 20.3237 12.8724 20.5999 12.0012 20.5999V22.5999C13.2906 22.5999 14.4891 22.1918 15.4152 21.4936L14.2111 19.8966ZM3.92819 6.37649C4.46301 5.04239 5.41497 3.94157 6.64253 3.28029L5.69402 1.51952C4.02696 2.41754 2.76905 3.89303 2.07181 5.63229L3.92819 6.37649ZM17.3258 3.28494C18.5894 3.98301 19.5652 5.06289 20.0679 6.35675L21.9321 5.63243C21.2476 3.87053 19.936 2.44204 18.293 1.53434L17.3258 3.28494Z" />
										</svg>
										<span>Hari ini</span>
									</div>
									<% if (Validator.isNotNull(events.get(i).getStartTime())) { %>
										<div class="display-flex gap-8px">
											<svg class="icon-time" xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none">
												<path d="M15.2838 15.3486C15.8077 15.5232 16.3741 15.2401 16.5487 14.7161C16.7234 14.1922 16.4402 13.6259 15.9163 13.4512L15.2838 15.3486ZM12 13.1999H11C11 13.6303 11.2755 14.0125 11.6838 14.1486L12 13.1999ZM13 8.18216C13 7.62988 12.5523 7.18216 12 7.18216C11.4477 7.18216 11 7.62988 11 8.18216H13ZM15.9163 13.4512L12.3163 12.2512L11.6838 14.1486L15.2838 15.3486L15.9163 13.4512ZM13 13.1999V8.18216H11V13.1999H13ZM20.6 11.9999C20.6 16.7495 16.7497 20.5999 12 20.5999V22.5999C17.8542 22.5999 22.6 17.8541 22.6 11.9999H20.6ZM12 20.5999C7.25037 20.5999 3.40002 16.7495 3.40002 11.9999H1.40002C1.40002 17.8541 6.14581 22.5999 12 22.5999V20.5999ZM3.40002 11.9999C3.40002 7.25025 7.25037 3.3999 12 3.3999V1.3999C6.14581 1.3999 1.40002 6.14568 1.40002 11.9999H3.40002ZM12 3.3999C16.7497 3.3999 20.6 7.25025 20.6 11.9999H22.6C22.6 6.14568 17.8542 1.3999 12 1.3999V3.3999Z" />
											</svg>
												<span><%= events.get(i).getStartTime() %></span>
										</div>
									<% } %>
								</div>
								<div class="label-event white">
									<% if (events.get(i).getCategory().equalsIgnoreCase("event")) { %>
										<svg class="mt-2px mr-6px" xmlns="http://www.w3.org/2000/svg" width="11" height="13" viewBox="0 0 11 13" fill="none">
											<path d="M0 11.375V5H10.5V11.375C10.5 12.0078 9.98438 12.5 9.375 12.5H1.125C0.492188 12.5 0 12.0078 0 11.375ZM7.5 6.78125V7.71875C7.5 7.88281 7.61719 8 7.78125 8H8.71875C8.85938 8 9 7.88281 9 7.71875V6.78125C9 6.64062 8.85938 6.5 8.71875 6.5H7.78125C7.61719 6.5 7.5 6.64062 7.5 6.78125ZM7.5 9.78125V10.7188C7.5 10.8828 7.61719 11 7.78125 11H8.71875C8.85938 11 9 10.8828 9 10.7188V9.78125C9 9.64062 8.85938 9.5 8.71875 9.5H7.78125C7.61719 9.5 7.5 9.64062 7.5 9.78125ZM4.5 6.78125V7.71875C4.5 7.88281 4.61719 8 4.78125 8H5.71875C5.85938 8 6 7.88281 6 7.71875V6.78125C6 6.64062 5.85938 6.5 5.71875 6.5H4.78125C4.61719 6.5 4.5 6.64062 4.5 6.78125ZM4.5 9.78125V10.7188C4.5 10.8828 4.61719 11 4.78125 11H5.71875C5.85938 11 6 10.8828 6 10.7188V9.78125C6 9.64062 5.85938 9.5 5.71875 9.5H4.78125C4.61719 9.5 4.5 9.64062 4.5 9.78125ZM1.5 6.78125V7.71875C1.5 7.88281 1.61719 8 1.78125 8H2.71875C2.85938 8 3 7.88281 3 7.71875V6.78125C3 6.64062 2.85938 6.5 2.71875 6.5H1.78125C1.61719 6.5 1.5 6.64062 1.5 6.78125ZM1.5 9.78125V10.7188C1.5 10.8828 1.61719 11 1.78125 11H2.71875C2.85938 11 3 10.8828 3 10.7188V9.78125C3 9.64062 2.85938 9.5 2.71875 9.5H1.78125C1.61719 9.5 1.5 9.64062 1.5 9.78125ZM9.375 2C9.98438 2 10.5 2.51562 10.5 3.125V4.25H0V3.125C0 2.51562 0.492188 2 1.125 2H2.25V0.875C2.25 0.6875 2.41406 0.5 2.625 0.5H3.375C3.5625 0.5 3.75 0.6875 3.75 0.875V2H6.75V0.875C6.75 0.6875 6.91406 0.5 7.125 0.5H7.875C8.0625 0.5 8.25 0.6875 8.25 0.875V2H9.375Z" />
										</svg>
									<% } else { %>
										<svg class="mt-2px mr-6px" xmlns="http://www.w3.org/2000/svg" width="12" height="13" viewBox="0 0 12 13" fill="none">
											<path d="M6.25 12.5C5.40625 12.5 4.75 11.8438 4.75 11H7.72656C7.72656 11.8438 7.07031 12.5 6.25 12.5ZM11.2891 9.00781C11.4297 9.14844 11.5 9.33594 11.5 9.5C11.4766 9.89844 11.1953 10.25 10.7266 10.25H1.75C1.28125 10.25 1 9.89844 1 9.5C0.976562 9.33594 1.04688 9.14844 1.1875 9.00781C1.63281 8.51562 2.5 7.78906 2.5 5.375C2.5 3.57031 3.76562 2.11719 5.5 1.74219V1.25C5.5 0.851562 5.82812 0.5 6.25 0.5C6.64844 0.5 6.97656 0.851562 6.97656 1.25V1.74219C8.71094 2.11719 9.97656 3.57031 9.97656 5.375C9.97656 7.78906 10.8438 8.51562 11.2891 9.00781Z" />
										</svg>
									<% } %>
									<span class="text-12px"><%= events.get(i).getCategory() %></span>
								</div>
							</a>
							<a href="<%= host %>/dashboard/event-detail/<%= target %>" class="card-event__body link-event">
								<h5><%= events.get(i).getTitle() %></h5>
								<p class="agency-line-clamp-2"><%= events.get(i).getDescription().length() >= 250 ? events.get(i).getDescription().substring(0, 250) : events.get(i).getDescription() %></p>
							</a>
							<div class="card-event__footer <% if (Validator.isNotNull(events.get(i).getLink())) { %>flex-justify-between<% } else { %>flex-justify-end<% } %>">
								<a class="link-hover link-hover--white agency-self-center mark-event display-flex gap-8px" href="javascript:void(0)" data-target="<%= target %>">
									<svg class="agency-self-center" width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
										<path d="M21.5999 11.9999C21.5999 17.3018 17.3018 21.5999 11.9999 21.5999C6.69797 21.5999 2.3999 17.3018 2.3999 11.9999C2.3999 6.69797 6.69797 2.3999 11.9999 2.3999C13.5061 2.3999 14.9313 2.74677 16.1999 3.36498M19.7999 5.9999L11.3999 14.3999L8.9999 11.9999" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"></path>
									</svg>
									<span class="agency-self-center">Tandai selesai</span>
								</a>
								<% if (Validator.isNotNull(events.get(i).getLink())) { %>
									<a href="<%= events.get(i).getLink() %>" class="btn__agency btn--dark-blue display-block agency-text-center link-meet">
										<span class="position-relative order-10">Buka <i class="fas fa-arrow-right fa-fw ml-5px"></i></span>
									</a>
								<% } %>
							</div>
						</div>
					<% } else if ((events.get(i).getStartDate().getTime() / 1000) > timestamp) { %>
						<div class="card-event" id="bg-white">
							<a href="<%= host %>/dashboard/event-detail/<%= target %>" class="card-event__header flex-justify-between link-event">
								<div class="card-date-time flex-justify-between gap-12px align-items-center">
									<div class="display-flex gap-8px">
										<svg class="icon-calendar" xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none">
											<path d="M7.25 17.5534V17.4688M12.3125 17.5534V17.4688M12.3125 12.9688V12.8842M16.8125 12.9688V12.8842M3.875 8.46875H19.625M5.91071 2V3.68771M17.375 2V3.6875M17.375 3.6875H6.125C4.26104 3.6875 2.75 5.19854 2.75 7.0625V18.3126C2.75 20.1766 4.26104 21.6876 6.125 21.6876H17.375C19.239 21.6876 20.75 20.1766 20.75 18.3126L20.75 7.0625C20.75 5.19854 19.239 3.6875 17.375 3.6875Z" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
										</svg>
										<fmt:formatDate value="<%= events == null ? null : events.get(i).getStartDate() %>" pattern="d MMM yyyy" var="formattedStartDate" />
										<span>${formattedStartDate}</span>
									</div>
									<% if (Validator.isNotNull(events.get(i).getStartTime())) { %>
										<div class="display-flex gap-8px">
											<svg class="icon-time" xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none">
												<path d="M15.2838 15.3486C15.8077 15.5232 16.3741 15.2401 16.5487 14.7161C16.7234 14.1922 16.4402 13.6259 15.9163 13.4512L15.2838 15.3486ZM12 13.1999H11C11 13.6303 11.2755 14.0125 11.6838 14.1486L12 13.1999ZM13 8.18216C13 7.62988 12.5523 7.18216 12 7.18216C11.4477 7.18216 11 7.62988 11 8.18216H13ZM15.9163 13.4512L12.3163 12.2512L11.6838 14.1486L15.2838 15.3486L15.9163 13.4512ZM13 13.1999V8.18216H11V13.1999H13ZM20.6 11.9999C20.6 16.7495 16.7497 20.5999 12 20.5999V22.5999C17.8542 22.5999 22.6 17.8541 22.6 11.9999H20.6ZM12 20.5999C7.25037 20.5999 3.40002 16.7495 3.40002 11.9999H1.40002C1.40002 17.8541 6.14581 22.5999 12 22.5999V20.5999ZM3.40002 11.9999C3.40002 7.25025 7.25037 3.3999 12 3.3999V1.3999C6.14581 1.3999 1.40002 6.14568 1.40002 11.9999H3.40002ZM12 3.3999C16.7497 3.3999 20.6 7.25025 20.6 11.9999H22.6C22.6 6.14568 17.8542 1.3999 12 1.3999V3.3999Z" />
											</svg>
											<span><%= events.get(i).getStartTime() %></span>
										</div>
									<% } %>
								</div>
								<div class="label-event ocean">
									<% if (events.get(i).getCategory().equalsIgnoreCase("event")) { %>
										<svg class="mt-2px mr-6px" xmlns="http://www.w3.org/2000/svg" width="11" height="13" viewBox="0 0 11 13" fill="none">
											<path d="M0 11.375V5H10.5V11.375C10.5 12.0078 9.98438 12.5 9.375 12.5H1.125C0.492188 12.5 0 12.0078 0 11.375ZM7.5 6.78125V7.71875C7.5 7.88281 7.61719 8 7.78125 8H8.71875C8.85938 8 9 7.88281 9 7.71875V6.78125C9 6.64062 8.85938 6.5 8.71875 6.5H7.78125C7.61719 6.5 7.5 6.64062 7.5 6.78125ZM7.5 9.78125V10.7188C7.5 10.8828 7.61719 11 7.78125 11H8.71875C8.85938 11 9 10.8828 9 10.7188V9.78125C9 9.64062 8.85938 9.5 8.71875 9.5H7.78125C7.61719 9.5 7.5 9.64062 7.5 9.78125ZM4.5 6.78125V7.71875C4.5 7.88281 4.61719 8 4.78125 8H5.71875C5.85938 8 6 7.88281 6 7.71875V6.78125C6 6.64062 5.85938 6.5 5.71875 6.5H4.78125C4.61719 6.5 4.5 6.64062 4.5 6.78125ZM4.5 9.78125V10.7188C4.5 10.8828 4.61719 11 4.78125 11H5.71875C5.85938 11 6 10.8828 6 10.7188V9.78125C6 9.64062 5.85938 9.5 5.71875 9.5H4.78125C4.61719 9.5 4.5 9.64062 4.5 9.78125ZM1.5 6.78125V7.71875C1.5 7.88281 1.61719 8 1.78125 8H2.71875C2.85938 8 3 7.88281 3 7.71875V6.78125C3 6.64062 2.85938 6.5 2.71875 6.5H1.78125C1.61719 6.5 1.5 6.64062 1.5 6.78125ZM1.5 9.78125V10.7188C1.5 10.8828 1.61719 11 1.78125 11H2.71875C2.85938 11 3 10.8828 3 10.7188V9.78125C3 9.64062 2.85938 9.5 2.71875 9.5H1.78125C1.61719 9.5 1.5 9.64062 1.5 9.78125ZM9.375 2C9.98438 2 10.5 2.51562 10.5 3.125V4.25H0V3.125C0 2.51562 0.492188 2 1.125 2H2.25V0.875C2.25 0.6875 2.41406 0.5 2.625 0.5H3.375C3.5625 0.5 3.75 0.6875 3.75 0.875V2H6.75V0.875C6.75 0.6875 6.91406 0.5 7.125 0.5H7.875C8.0625 0.5 8.25 0.6875 8.25 0.875V2H9.375Z" fill="white"/>
										</svg>
									<% } else { %>
										<svg class="mt-2px mr-6px" xmlns="http://www.w3.org/2000/svg" width="12" height="13" viewBox="0 0 12 13" fill="none">
											<path d="M6.25 12.5C5.40625 12.5 4.75 11.8438 4.75 11H7.72656C7.72656 11.8438 7.07031 12.5 6.25 12.5ZM11.2891 9.00781C11.4297 9.14844 11.5 9.33594 11.5 9.5C11.4766 9.89844 11.1953 10.25 10.7266 10.25H1.75C1.28125 10.25 1 9.89844 1 9.5C0.976562 9.33594 1.04688 9.14844 1.1875 9.00781C1.63281 8.51562 2.5 7.78906 2.5 5.375C2.5 3.57031 3.76562 2.11719 5.5 1.74219V1.25C5.5 0.851562 5.82812 0.5 6.25 0.5C6.64844 0.5 6.97656 0.851562 6.97656 1.25V1.74219C8.71094 2.11719 9.97656 3.57031 9.97656 5.375C9.97656 7.78906 10.8438 8.51562 11.2891 9.00781Z" />
										</svg>
									<% } %>
									<span class="text-12px"><%= events.get(i).getCategory() %></span>
								</div>
							</a>
							<a href="<%= host %>/dashboard/event-detail/<%= target %>" class="card-event__body link-event">
								<h5><%= events.get(i).getTitle() %></h5>
								<p class="agency-line-clamp-2"><%= events.get(i).getDescription().length() >= 250 ? events.get(i).getDescription().substring(0, 250) : events.get(i).getDescription() %></p>
							</a>
							<div class="card-event__footer <% if (Validator.isNotNull(events.get(i).getLink())) { %>flex-justify-between<% } else { %>flex-justify-end<% } %>">
								<a class="link-hover link-hover--blue agency-self-center link-event" href="<%= host %>/dashboard/event-detail/<%= target %>">Baca</a>
								<% if (Validator.isNotNull(events.get(i).getLink())) { %>
									<a href="<%= events.get(i).getLink() %>" class="btn__agency btn--dark-blue display-block agency-text-center link-meet">
										<span class="position-relative order-10">Buka <i class="fas fa-arrow-right fa-fw ml-5px"></i></span>
									</a>
								<% } %>
							</div>
						</div>
					<% } %>
				<% } %>
			</div>
		
			<div class="bg-gradient-bottom-scroll"></div>
		<% } %>
	</div>
</div>

<!-- MODAL -->

<!-- Modal Create a Reminder -->
<div class="modal modal-agency width-full fade" id="ModalCreateReminder" tabindex="-1" style="display: none;" aria-labelledby="ModalCreateReminderLabel" aria-hidden="true">
	<div class="modal-max-w-676px modal-dialog modal-agency-dialog modal-agency-dialog-centered">
		<div class="modal-agency-content modal-content">
			<div class="modal-agency-header">
				<h1>Buat Pengingat</h1>
			</div>
			<div class="multi-step-form">
				<form class="reminder-form" id="formReminder" action="javascript:void()" autocomplete="off" novalidate="novalidate">
					<fieldset aria-label="Reminder" id="reminder">
						<div class="modal-agency-body p-20px position-relative">
							<div class="mb-15px position-relative">
								<label class="label__agency" for="title">Judul<sup>*</sup></label>
								<input class="input-control agency-normalcase input-control--outline agency-bg-transparent" name="title" id="title" type="text" placeholder="Masukan judul" required>
							</div>

							<div class="mb-15px display-grid grid-cols-2-lg gap-12px position-relative">
								<div class="input-col calendar position-relative">
									<label class="label__agency" for="datepickerReminder">Tanggal<sup>*</sup></label>
									<input type="text" class="input-control input-date agency-normalcase input-control--outline agency-bg-transparent" name="datepickerReminder" id="datepickerReminder" autocomplete="off" required>
								</div>
								<div class="input-col">
									<label class="label__agency" for="time">Jam<sup>*</sup></label>
									<input type="text" class="input-control agency-normalcase input-control--outline agency-bg-transparent time disabled" name="time" id="time" autocomplete="off" required disabled>
								</div>
							</div>
							<div class="mb-15px">
								<div class="display-flex agency-items-center">
									<input type="checkbox" id="days" class="input-switch" checked>
									<label for="days" class="label__agency label-text-switch text-16px agency-self-center mb-0px ml-8px agency-pointer">Seharian</label>
								</div>
							</div>
							<div class="mb-15px">
								<label class="label__agency" for="url">Tautan</label>
								<input class="input-control agency-normalcase input-control--outline agency-bg-transparent" type="text" id="url" name="url">
							</div>
							<div class="mb-15px">
								<label class="label__agency" for="message">Pesan</label>
								<textarea class="input-control" id="message" rows="3" placeholder="Masukkan Pesan" name="message"></textarea>
							</div>
							
						</div>
						<div class="modal-agency-footer flex-justify-between p-20px-30px">
							<a class="btn-cancel-create-reminder text-14px agency-uppercase agency-self-center agency-pointer" data-bs-toggle="modal" data-bs-target="#ModalCreateReminder">Batalkan</a>
							<button type="button" class="btn-prev-create-reminder text-14px agency-uppercase agency-self-center display-none" data-bs-toggle="modal" data-bs-target="#ModalBackReminder" aria-label="Close">Batalkan</button>
							<button type="button" class="btn__agency btn--dark-blue p-12px-30px-10px-30px btn-create-reminder">
								<span class="position-relative order-50">
									Buat Pengingat 
									<svg class="w-16px h-16px display-inline-block vertical-align-middle position-relative top-min-1px left-5px" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 16 16" fill="none">
										<path d="M12.8 7.99995L3.20005 7.99995M8.00005 12.8L8.00005 3.19995" stroke-width="2" stroke-linecap="round"/>
									</svg>
								</span>
							</button>
						</div>
					</fieldset>
				</form>
			</div>
		</div>
	</div>
</div>

<!-- Modal Success Create a Reminder -->
<div class="modal modal-agency width-full fade" id="ModalSuccessReminder" tabindex="-1" style="display: none;" aria-labelledby="ModalSuccessReminderLabel" aria-hidden="true">
	<div class="modal-max-w-560px modal-agency-dialog modal-dialog modal-agency-dialog-centered">
		<div class="modal-content modal-agency-content">
			<div class="modal-agency-body agency-text-center p-80px-40px position-relative">
				<svg class="w-82px-h-82px m-0-auto-20px-auto" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 80 80" fill="none">
					<g clip-path="url(#clip0_399_12662)">
						<path d="M50.6991 69.6175C49.7643 69.6199 49.0123 68.8115 49.0928 67.8775L49.5614 62.0651C50.113 55.0547 52.5163 48.3614 56.3883 42.636C60.0703 37.2608 59.3658 29.9259 54.7031 24.7584C54.1081 24.0982 54.1597 23.0796 54.8207 22.4838C55.4817 21.888 56.4994 21.9412 57.0952 22.6006C62.7579 28.8767 63.5719 37.8478 59.0727 44.4146C55.501 49.6916 53.2788 55.8558 52.7716 62.3228L52.303 68.136C52.2345 68.979 51.53 69.6175 50.6991 69.6175Z" fill="#1F1F9C"/>
						<path d="M9.85902 41.6384C8.22376 41.6939 7.61667 39.2592 9.15854 38.5772C16.7705 35.3348 23.9782 30.4637 28.3196 23.4033C32.859 16.5168 42.475 14.2632 49.9822 17.5659C51.9081 18.3952 50.6875 21.3421 48.7318 20.5337C42.6296 17.8332 34.6851 19.5941 31.0023 25.1851C26.2246 32.768 18.3316 38.5329 9.85902 41.6384Z" fill="#1F1F9C"/>
						<path d="M48.5653 78.5868C47.3021 78.5868 46.0694 78.2076 45.005 77.4789L3.08144 48.7567C-3.71163 44.0739 3.38257 33.6657 10.2288 38.3243L52.1523 67.0458C57.2457 70.2817 54.608 78.8098 48.5653 78.5868ZM46.8246 74.8211C50.0943 77.1408 53.6982 71.929 50.3318 69.7028L8.40833 40.9805C6.26019 39.3896 3.01381 41.4918 3.6056 44.1094C3.75777 44.9242 4.21832 45.6303 4.90189 46.0989L46.8246 74.8211Z" fill="#1F1F9C"/>
						<path d="M55.8995 25.2905C54.4703 25.3413 53.7086 23.3839 54.8415 22.4661C55.1273 22.2728 56.2948 20.3992 56.5331 20.1029C57.7553 18.4347 56.24 15.8437 54.1402 16.2865C52.5846 16.4596 51.6378 18.4459 50.8503 19.6545C49.3874 22.1319 46.4574 19.6472 48.4228 17.4266L49.6587 15.6239C54.0975 9.42419 63.302 15.4411 59.1901 21.9234C58.3214 22.9451 57.4526 25.2575 55.8995 25.2905Z" fill="#1F1F9C"/>
						<path d="M24.9556 79.9983C19.6529 80.0861 15.0168 75.5273 14.9951 70.2261C14.958 67.4395 16.02 64.8437 17.987 62.9154C18.5361 62.3775 19.3896 62.301 20.0249 62.7374L33.5377 71.9991C34.1698 72.4323 34.4089 73.2511 34.1094 73.9564C32.5265 77.6883 28.8872 79.9983 24.9556 79.9983ZM19.4009 66.2149C14.4862 73.6416 25.4347 81.0691 30.5249 73.8389L19.4009 66.2149Z" fill="#1F1F9C"/>
						<path d="M29.7744 15.6215C28.5465 15.6537 27.7156 14.1682 28.4209 13.14C31.7059 8.02647 38.2478 8.63598 38.5248 8.66335C40.6262 8.91536 40.3025 12.0434 38.2011 11.8679C38.1053 11.8582 33.3243 11.4653 31.1302 14.8807C30.8235 15.3598 30.3041 15.6207 29.7744 15.6215Z" fill="#1F1F9C"/>
						<path d="M22.9243 11.1506C21.7278 11.1788 20.8953 9.76899 21.5306 8.73598C27.2592 -1.20363 38.0901 0.0202023 38.5491 0.0749527C39.4315 0.184453 40.0579 0.988801 39.9484 1.87125C39.8389 2.75209 39.0402 3.37366 38.1554 3.27141C37.7641 3.22471 28.9597 2.29556 24.3212 10.3439C24.0233 10.8616 23.4814 11.1506 22.9243 11.1506Z" fill="#1F1F9C"/>
						<path d="M67.313 44.3873C66.0151 44.4275 65.1979 42.7762 66.0553 41.7729C66.1125 41.6997 69.0433 37.8985 67.3669 34.1989C66.5272 32.2601 69.3943 30.9549 70.3017 32.8704C72.809 38.4066 68.7446 43.5684 68.5706 43.785C68.251 44.182 67.784 44.3873 67.313 44.3873Z" fill="#1F1F9C"/>
						<path d="M74.5324 49.0476C73.22 49.0903 72.1661 47.3366 73.2965 46.4067C73.5864 46.1676 79.117 39.2239 74.8762 30.9477C74.4712 30.1563 74.7836 29.1861 75.5751 28.7803C76.3658 28.3729 77.3368 28.6869 77.7426 29.4791C82.964 39.6056 76.0928 49.4759 74.5324 49.0476Z" fill="#1F1F9C"/>
						<path d="M24.7059 40.5419C22.9265 40.5861 22.4201 38.0427 24.1182 37.4195C26.7905 36.4396 29.2744 33.5354 30.0063 32.4992C31.2542 30.7931 33.8299 32.6055 32.6375 34.3567C32.6576 34.3953 28.7357 39.6787 24.7059 40.5419Z" fill="#1F1F9C"/>
					</g>
					<defs>
						<clipPath id="clip0_399_12662">
							<rect width="80" height="80" fill="white"/>
						</clipPath>
					</defs>
				</svg>
				<h1 class="text-32px mb-15px">Pengingat Berhasil Dibuat</h1>
				<p class="mb-20px">Pengingat telah berhasil dibuat, anda bisa <br/>tekan tombol &ldquo;kembali&rdquo;</p>
				<button type="button" class="btn__agency btn--dark-blue btn-prev-modal p-12px-30px-10px-30px" data-bs-dismiss="modal" aria-label="Close"><span class="position-relative order-50">Kembali</span></button>
			</div>
		</div>
	</div>
</div>

<!-- Modal Warning -->
<div class="modal modal-agency width-full fade" id="ModalBackReminder" tabindex="-1" style="display: none;" aria-labelledby="ModalBackReminderLabel" aria-hidden="true">
	<div class="modal-max-w-430px modal-agency-dialog modal-dialog modal-agency-dialog-centered">
		<div class="modal-agency-content">
			<div class="modal-agency-body agency-text-center p-80px-40px-0px-40px position-relative">
				<svg class="w-100px-h-100px m-0-auto-20px-auto" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 100 100" fill="none">
					<path d="M50.0017 54.0462V33.8864M50.0017 68.9888V69.166M75.2014 85.956H24.802C17.9177 85.956 12.108 81.3551 10.2802 75.0604C9.49989 72.3733 10.4586 69.5745 11.9251 67.1915L37.1248 21.2417C43.0288 11.6476 56.9746 11.6476 62.8787 21.2418L88.0783 67.1915C89.5448 69.5745 90.5035 72.3733 89.7232 75.0603C87.8954 81.3551 82.0857 85.956 75.2014 85.956Z" stroke="#1F1F9C" stroke-width="8.33333" stroke-linecap="round" stroke-linejoin="round"/>
				</svg>
				<h1 class="text-32px mb-15px">Peringatan!</h1>
				<p class="mb-20px">Apakah anda yakin membatalkan proses ini?</p>
			</div>
			<div class="modal-agency-footer flex-justify-between p-20px-30px mt-48px">
				<button class="btn-no text-14px agency-uppercase agency-self-center" data-bs-toggle="modal" data-bs-target="#ModalCreateReminder" aria-label="Close">Tidak</button>
				<button type="button" class="btn__agency btn--dark-blue btn-close btn-prev-modal p-12px-25px-10px-25px" type="button" data-bs-dismiss="modal" aria-label="Close" aria-controls="reminder">
					<span class="position-relative order-50">
						Iya
						<svg class="display-inline-block position-relative top-min-1px left-6px" xmlns="http://www.w3.org/2000/svg" width="16" height="16" viewBox="0 0 16 16" fill="none">
							<path d="M5.22353 4L11.9059 4.09412M11.9059 4.09412L12 10.7765M11.9059 4.09412L4 12" stroke="white" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
						</svg>
					</span>
				</button>
			</div>
		</div>
	</div>
</div>

<script>
	window.host = "<%= host %>";
	window.rToken = "<%= renderToken %>";
	window.apToken = "<%= apiRequestToken %>";
</script>
<script src="/o/agency-theme/js/datepicker/single-datepicker.js" type="text/javascript"></script>
<script src="<%= request.getContextPath() %>/dashboard/includes/js/calendar.js" type="text/javascript"></script>