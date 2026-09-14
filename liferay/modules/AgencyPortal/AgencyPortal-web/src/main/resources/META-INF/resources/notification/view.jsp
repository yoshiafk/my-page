<%@ include file="../init.jsp" %>

<%  
    ActionHelpers helpers = new ActionHelpers();
    String host = helpers.getConfig("com.mypage.agent.config.pimcoreHost");
    
    int size = (int) renderRequest.getAttribute("size");
	int current_page_notification = (int) renderRequest.getAttribute("current_page_notification");
	int current_page_message = (int) renderRequest.getAttribute("current_page_message");
	int total_pages_notification = (int) renderRequest.getAttribute("total_pages_notification");
	int total_pages_message = (int) renderRequest.getAttribute("total_pages_message");
	
	int previousPageNotification = Math.max(1, current_page_notification - 1);
	int previousPageMessage = Math.max(1, current_page_message - 1);
	int nextPageNotification = Math.min(total_pages_notification, current_page_notification + 1);
	int nextPageMessage = Math.min(total_pages_message, current_page_message + 1);
	
	int startNotification = current_page_notification > 0 ? (current_page_notification - 1) * size : 0;
	int startMessage = current_page_message > 0 ? (current_page_message - 1) * size : 0;
    
    List<AgentNotification> notifications = (List<AgentNotification>) renderRequest.getAttribute("notifications");
	int endNotification = current_page_notification > 0 ? Math.min(current_page_notification * size, notifications.size()) : 0;
    notifications = notifications.subList(startNotification, endNotification);

    List<AgentNotification> messages = (List<AgentNotification>) renderRequest.getAttribute("messages");
	int endMessage = current_page_message > 0 ? Math.min(current_page_message * size, messages.size()) : 0;
	messages = messages.subList(startMessage, endMessage);
	
	String renderToken = !Validator.isNull((String) renderRequest.getAttribute("renderToken")) ? (String) renderRequest.getAttribute("renderToken") : "";
    String apiRequestToken = !Validator.isNull((String) renderRequest.getAttribute("apiRequestToken")) ? (String) renderRequest.getAttribute("apiRequestToken") : "";
%>

<portlet:resourceURL id="/data/agentnotification" var="loadAgentNotificationData" />

<div class="breadcrumbs container-breadcrumbs-axa">
	<nav class="width-full">
		<ol class="list-reset display-inline-flex">
			<li class="text-13px agency-self-center">
				<a href="<%= host %>/dashboard" class="link-dashboard">Beranda</a>
			</li>
			<li class="agency-self-center">
				<span class="text-13px">/</span>
			</li>
			<li class="text-13px agency-uppercase agency-self-center">Notifikasi</li>
		</ol>
	</nav>
</div>

<div class="dashboard">
	<div class="dashboard__notification">
       	<div class="container-axa">
			<div class="dashboard__notification--inner">
				<div class="dashboard__notification--left">
					<div class="nav-pills" id="v-pills-tab" role="tablist" aria-orientation="vertical">
						<button class="nav-link display-block active" id="v-pills-Notification-tab" data-bs-toggle="pill" data-bs-target="#v-pills-Notification" type="button" role="tab" aria-controls="v-pills-Notification" aria-selected="true">
							<span>Notifikasi</span>
						</button>
						<button class="nav-link display-block" id="v-pills-Message-tab" data-bs-toggle="pill" data-bs-target="#v-pills-Message" type="button" role="tab" aria-controls="v-pills-Message" aria-selected="false">
							<span>Pesan</span>
						</button>
					</div>
					<div id="sticky" class="display-none"></div>
				</div>
				<div class="dashboard__notification--right">
					<div class="tab-content" id="v-pills-tabContent">
						<div class="tab-pane fade show active" id="v-pills-Notification" role="tabpanel" aria-labelledby="v-pills-Notification-tab" tabindex="0">
							<% if (notifications.size() > 0) { %>
								<% for (int i = 0; i < notifications.size(); i++) { %>
									<% 
										String target = EncryptionHelper.encryptRandom(String.valueOf(notifications.get(i).getAgentNotificationId()));
										String link = notifications.get(i).getLink();
							            if (notifications.get(i).getCategory().equalsIgnoreCase("transaksi berhasil") == true || notifications.get(i).getCategory().equalsIgnoreCase("transaksi kedaluwarsa") == true) {
								            String[] parts = notifications.get(i).getLink().split("/");
								            String lastPart = parts[parts.length - 1];
								            String newLastPart = EncryptionHelper.encryptRandom(lastPart);
								            link = notifications.get(i).getLink().substring(0, notifications.get(i).getLink().lastIndexOf("/") + 1) + newLastPart;
							            }
							            String url = notifications.get(i).getReferenceId() > 0 ? 
							            			 host.concat("/dashboard/event-detail/").concat(EncryptionHelper.encryptRandom(String.valueOf(notifications.get(i).getReferenceId()))) : link;
									%>
									<div class="card-notif <% if (notifications.get(i).getIsRead() == 0) { %>unread<% } %>">
										<a href="<%= url %>" class="link-notification" data-target="<%= target %>">
											<div class="card-header-notif">
												<h5><%= notifications.get(i).getTitle() %></h5>
												<ul>
													<li>
														<svg class="icon-calendar" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="none">
															<path d="M7.25 17.5534V17.4688M12.3125 17.5534V17.4688M12.3125 12.9688V12.8842M16.8125 12.9688V12.8842M3.875 8.46875H19.625M5.91071 2V3.68771M17.375 2V3.6875M17.375 3.6875H6.125C4.26104 3.6875 2.75 5.19854 2.75 7.0625V18.3126C2.75 20.1766 4.26104 21.6876 6.125 21.6876H17.375C19.239 21.6876 20.75 20.1766 20.75 18.3126L20.75 7.0625C20.75 5.19854 19.239 3.6875 17.375 3.6875Z" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"></path>
														</svg>
														<fmt:formatDate value="<%= notifications.get(i).getCreateDate() %>" pattern="d MMM yyyy" var="formattedStartDate" />
									                    <%-- <fmt:formatDate value="<%= Validator.isNull(notifications.get(i).getEndDate()) ? null : notifications.get(i).getEndDate() %>" pattern="d MMM yyyy" var="formattedEndDate" />
									                    <% if (notifications.get(i).getIsAllDay() == 1 && Validator.isNull(notifications.get(i).getEndDate())) { %> --%>
									                    	<span>${formattedStartDate}</span>
									                   	<%-- <% } %>
									                   	<% if (notifications.get(i).getIsAllDay() == 1 && Validator.isNotNull(notifications.get(i).getEndDate())) { %>
									                    	<% if (notifications.get(i).getStartDate().equals(notifications.get(i).getEndDate())) { %>
									                   			<span>${formattedStartDate}</span>
									                    	<% } else { %>
									                    		<span>${formattedStartDate} - ${formattedEndDate}</span>
									                    	<% } %>
									                   	<% } %>
									                   	<% if (notifications.get(i).getIsAllDay() == 0 && Validator.isNull(notifications.get(i).getEndDate())) { %>
									                    	<span>${formattedStartDate} | <%= notifications.get(i).getStartTime() %></span>
									                   	<% } %>
									                   	<% if (notifications.get(i).getIsAllDay() == 0 && (Validator.isNotNull(notifications.get(i).getStartDate()) && Validator.isNotNull(notifications.get(i).getEndDate()))) { %>
									                   		<% if (notifications.get(i).getStartDate().equals(notifications.get(i).getEndDate())) { %>
									                    		<span>${formattedStartDate} | <%= notifications.get(i).getStartTime() %> - <%= notifications.get(i).getEndTime() %></span>
									                    	<% } else { %>
									                    		<span>${formattedStartDate} - ${formattedEndDate} | <%= notifications.get(i).getStartTime() %> - <%= notifications.get(i).getEndTime() %></span>
									                    	<% } %>
									                   	<% } %> --%>
													</li>
													<%-- <% if (Validator.isNotNull(notifications.get(i).getLocation())) { %>
														<li>
															<svg class="icon-marker" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 23 23" fill="none">
																<path d="M11.0266 16.5396V9.1887V3.67554L15.9885 7.53475L11.5779 10.8426M7.71872 13.1313C4.486 13.6765 2.20557 14.9971 2.20557 16.5396C2.20557 18.5695 6.15489 20.215 11.0266 20.215C15.8984 20.215 19.8477 18.5695 19.8477 16.5396C19.8477 14.9971 17.5672 13.6765 14.3345 13.1313" stroke-width="1.83772" stroke-linecap="round" stroke-linejoin="round"></path>
															</svg>
															<span><%= notifications.get(i).getLocation() %></span>
														</li>
													<% } %> --%>
												</ul>
											</div>
											<div class="card-body-notif">
												<p class="agency-line-clamp-2"><%= notifications.get(i).getDescription().length() >= 250 ? notifications.get(i).getDescription().substring(0, 250) : notifications.get(i).getDescription() %></p>
											</div>
										</a>
									</div>
								<% } %>
							<% } %>
				
							<div class="agency-text-center">
								<nav aria-label="Page navigation">
									<ul class="pagination">
										<li>
											<% if (current_page_notification > 1) { %>
												<a class="prev" aria-label="Previous" href="javascript:void(0)" onclick="page(<%= previousPageNotification %>)" data-category="notifikasi">Sebelumnya</a>
												<a class="prev-mobile" aria-label="Previous" href="javascript:void(0)" onclick="page(<%= previousPageNotification %>)" data-category="notifikasi"><i class="fas fa-chevron-left"></i></a>
											<% } else { %>
												<a class="disabled prev" aria-label="Previous" href="javascript:void(0)" onclick="page(<%= previousPageNotification %>)" data-category="notifikasi">Sebelumnya</a>
												<a class="disabled prev-mobile" aria-label="Previous" href="javascript:void(0)" onclick="page(<%= previousPageNotification %>)" data-category="notifikasi"><i class="fas fa-chevron-left"></i></a>
											<% } %>
										</li>
										
										<% if (current_page_notification > 4) { %>
								            <li><a href="javascript:void(0)" onclick="page(1)" data-category="notifikasi">1</a></li>
								            <li><a class="disabled">...</a></li>
								        <% } %>
								        
								        <%
								        	int iteratorUpNotification = current_page_notification == 1 ? 4 : current_page_notification == 2 ? 3 : current_page_notification == 3 ? 2 : 1;
								        	int iteratorDownNotification = current_page_notification == (total_pages_notification - 4) ? 0 : current_page_notification == (total_pages_notification - 3) ? 1 : current_page_notification == (total_pages_notification - 2) ? 2 : current_page_notification == (total_pages_notification - 1) ? 3 : 4;
								        %>
								        
								        <% if (current_page_notification <= 4) { %>
								        	<% for (int i = Math.max(1, current_page_notification - 4); i <= Math.min(total_pages_notification, current_page_notification + iteratorUpNotification); i++) { %>
									            <li><a <% if (i == current_page_notification) { %>class="active" aria-current="page"<% } %> href="javascript:void(0)" onclick="page(<%= i %>)" data-category="notifikasi"><%= i %></a></li>
									        <% } %>
								        <% } else if (current_page_notification >= total_pages_notification - 4) { %>
								        	<% for (int i = Math.max(1, current_page_notification - iteratorDownNotification); i <= total_pages_notification; i++) { %>
									            <li><a <% if (i == current_page_notification) { %>class="active" aria-current="page"<% } %> href="javascript:void(0)" onclick="page(<%= i %>)" data-category="notifikasi"><%= i %></a></li>
									        <% } %>
								        <% } else { %>
									        <% for (int i = Math.max(1, current_page_notification - 1); i <= Math.min(total_pages_notification, current_page_notification + 1); i++) { %>
									            <li><a <% if (i == current_page_notification) { %>class="active" aria-current="page"<% } %> href="javascript:void(0)" onclick="page(<%= i %>)" data-category="notifikasi"><%= i %></a></li>
									        <% } %>
								        <% } %>
								        
								        <% if (current_page_notification < total_pages_notification - 4) { %>
								            <li><a class="disabled">...</a></li>
								            <li><a href="javascript:void(0)" onclick="page(<%= total_pages_notification %>)" data-category="notifikasi"><%= total_pages_notification %></a></li>
								        <% } %>
								        
										<li>
											<% if (current_page_notification < total_pages_notification) { %>
												<a class="next" aria-label="Next" href="javascript:void(0)" onclick="page(<%= nextPageNotification %>)" data-category="notifikasi">Selanjutnya</a>
												<a class="next-mobile" aria-label="Next" href="javascript:void(0)" onclick="page(<%= nextPageNotification %>)" data-category="notifikasi"><i class="fas fa-chevron-right"></i></a>
											<% } else { %>
												<a class="disabled next" aria-label="Next" href="javascript:void(0)" onclick="page(<%= nextPageNotification %>)" data-category="notifikasi">Selanjutnya</a>
												<a class="disabled next-mobile" aria-label="Next" href="javascript:void(0)" onclick="page(<%= nextPageNotification %>)" data-category="notifikasi"><i class="fas fa-chevron-right"></i></a>
											<% } %>
										</li>
									</ul>
								</nav>
							</div>
						</div>
						<div class="tab-pane fade" id="v-pills-Message" role="tabpanel" aria-labelledby="v-pills-Message-tab" tabindex="0">
							<% if (messages.size() > 0) { %>
								<% for (int i = 0; i < messages.size(); i++) { %>
									<% 
										String target = EncryptionHelper.encryptRandom(String.valueOf(messages.get(i).getAgentNotificationId()));
										String link = messages.get(i).getLink();
							            if (messages.get(i).getCategory().equalsIgnoreCase("transaksi berhasil") == true || messages.get(i).getCategory().equalsIgnoreCase("transaksi kedaluwarsa") == true) {
								            String[] parts = messages.get(i).getLink().split("/");
								            String lastPart = parts[parts.length - 1];
								            String newLastPart = EncryptionHelper.encryptRandom(lastPart);
								            link = messages.get(i).getLink().substring(0, messages.get(i).getLink().lastIndexOf("/") + 1) + newLastPart;
							            }
							            String url = messages.get(i).getReferenceId() > 0 ? 
							            			 host.concat("/dashboard/event-detail/").concat(EncryptionHelper.encryptRandom(String.valueOf(messages.get(i).getReferenceId()))) : link;
									%>
									<div class="card-notif <% if (messages.get(i).getIsRead() == 0) { %>unread<% } %>">
										<a href="<%= url %>" class="link-notification" data-target="<%= target %>">
											<div class="card-header-notif">
												<h5><%= messages.get(i).getTitle() %></h5>
												<ul>
													<li>
														<svg class="icon-calendar" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="none">
															<path d="M7.25 17.5534V17.4688M12.3125 17.5534V17.4688M12.3125 12.9688V12.8842M16.8125 12.9688V12.8842M3.875 8.46875H19.625M5.91071 2V3.68771M17.375 2V3.6875M17.375 3.6875H6.125C4.26104 3.6875 2.75 5.19854 2.75 7.0625V18.3126C2.75 20.1766 4.26104 21.6876 6.125 21.6876H17.375C19.239 21.6876 20.75 20.1766 20.75 18.3126L20.75 7.0625C20.75 5.19854 19.239 3.6875 17.375 3.6875Z" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"></path>
														</svg>
														<fmt:formatDate value="<%= messages.get(i).getCreateDate() %>" pattern="d MMM yyyy" var="formattedStartDate" />
									                    <%-- <fmt:formatDate value="<%= Validator.isNull(messages.get(i).getEndDate()) ? null : messages.get(i).getEndDate() %>" pattern="d MMM yyyy" var="formattedEndDate" />
									                    <% if (messages.get(i).getIsAllDay() == 1 && Validator.isNull(messages.get(i).getEndDate())) { %> --%>
									                    	<span>${formattedStartDate}</span>
									                   	<%-- <% } %>
									                   	<% if (messages.get(i).getIsAllDay() == 1 && Validator.isNotNull(messages.get(i).getEndDate())) { %>
									                   		<% if (messages.get(i).getStartDate().equals(messages.get(i).getEndDate())) { %>
									                   			<span>${formattedStartDate}</span>
									                    	<% } else { %>
									                    		<span>${formattedStartDate} - ${formattedEndDate}</span>
									                    	<% } %>
									                   	<% } %>
									                   	<% if (messages.get(i).getIsAllDay() == 0 && Validator.isNull(messages.get(i).getEndDate())) { %>
									                    	<span>${formattedStartDate} | <%= messages.get(i).getStartTime() %></span>
									                   	<% } %>
									                   	<% if (messages.get(i).getIsAllDay() == 0 && (Validator.isNotNull(messages.get(i).getStartDate()) && Validator.isNotNull(messages.get(i).getEndDate()))) { %>
									                   		<% if (messages.get(i).getStartDate().equals(messages.get(i).getEndDate())) { %>
									                    		<span>${formattedStartDate} | <%= messages.get(i).getStartTime() %> - <%= messages.get(i).getEndTime() %></span>
									                    	<% } else { %>
									                    		<span>${formattedStartDate} - ${formattedEndDate} | <%= messages.get(i).getStartTime() %> - <%= messages.get(i).getEndTime() %></span>
									                    	<% } %>
									                   	<% } %> --%>
													</li>
													<%-- <% if (Validator.isNotNull(messages.get(i).getLocation())) { %>
														<li>
															<svg class="icon-marker" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 23 23" fill="none">
																<path d="M11.0266 16.5396V9.1887V3.67554L15.9885 7.53475L11.5779 10.8426M7.71872 13.1313C4.486 13.6765 2.20557 14.9971 2.20557 16.5396C2.20557 18.5695 6.15489 20.215 11.0266 20.215C15.8984 20.215 19.8477 18.5695 19.8477 16.5396C19.8477 14.9971 17.5672 13.6765 14.3345 13.1313" stroke-width="1.83772" stroke-linecap="round" stroke-linejoin="round"></path>
															</svg>
															<span><%= messages.get(i).getLocation() %></span>
														</li>
													<% } %> --%>
												</ul>
											</div>
											<div class="card-body-notif">
												<p class="agency-line-clamp-2"><%= messages.get(i).getDescription().length() >= 250 ? messages.get(i).getDescription().substring(0, 250) : messages.get(i).getDescription() %></p>
											</div>
										</a>
									</div>
								<% } %>
							<% } %>
				
							<div class="text-center">
								<nav aria-label="Page navigation">
									<ul class="pagination">
										<li>
											<% if (current_page_message > 1) { %>
												<a class="prev" aria-label="Previous" href="javascript:void(0)" onclick="page(<%= previousPageMessage %>" data-category="pesan">Sebelumnya</a>
												<a class="prev-mobile" aria-label="Previous" href="javascript:void(0)" onclick="page(<%= previousPageMessage %>" data-category="pesan"><i class="fas fa-chevron-left"></i></a>
											<% } else { %>
												<a class="disabled prev" aria-label="Previous" href="javascript:void(0)" onclick="page(<%= previousPageMessage %>)" data-category="pesan">Sebelumnya</a>
												<a class="disabled prev-mobile" aria-label="Previous" href="javascript:void(0)" onclick="page(<%= previousPageMessage %>)" data-category="pesan"><i class="fas fa-chevron-left"></i></a>
											<% } %>
										</li>
										
										<% if (current_page_message > 4) { %>
								            <li><a href="javascript:void(0)" onclick="page(1, event)" data-category="pesan">1</a></li>
								            <li><a class="disabled">...</a></li>
								        <% } %>
								        
								        <%
								        	int iteratorUpMessage = current_page_message == 1 ? 4 : current_page_message == 2 ? 3 : current_page_message == 3 ? 2 : 1;
								        	int iteratorDownMessage = current_page_message == (total_pages_message - 4) ? 0 : current_page_message == (total_pages_message - 3) ? 1 : current_page_message == (total_pages_message - 2) ? 2 : current_page_message == (total_pages_message - 1) ? 3 : 4;
								        %>
								        
								        <% if (current_page_message <= 4) { %>
								        	<% for (int i = Math.max(1, current_page_message - 4); i <= Math.min(total_pages_message, current_page_message + iteratorUpMessage); i++) { %>
									            <li><a <% if (i == current_page_message) { %>class="active" aria-current="page"<% } %> href="javascript:void(0)" onclick="page(<%= i %>)" data-category="pesan"><%= i %></a></li>
									        <% } %>
								        <% } else if (current_page_message >= total_pages_message - 4) { %>
								        	<% for (int i = Math.max(1, current_page_message - iteratorDownMessage); i <= total_pages_message; i++) { %>
									            <li><a <% if (i == current_page_message) { %>class="active" aria-current="page"<% } %> href="javascript:void(0)" onclick="page(<%= i %>)" data-category="pesan"><%= i %></a></li>
									        <% } %>
								        <% } else { %>
									        <% for (int i = Math.max(1, current_page_message - 1); i <= Math.min(total_pages_message, current_page_message + 1); i++) { %>
									            <li><a <% if (i == current_page_message) { %>class="active" aria-current="page"<% } %> href="javascript:void(0)" onclick="page(<%= i %>)" data-category="pesan"><%= i %></a></li>
									        <% } %>
								        <% } %>
								        
								        <% if (current_page_message < total_pages_message - 4) { %>
								            <li><a class="disabled">...</a></li>
								            <li><a href="javascript:void(0)" onclick="page(<%= total_pages_message %>)" data-category="pesan"><%= total_pages_message %></a></li>
								        <% } %>
								        
										<li>
											<% if (current_page_message < total_pages_message) { %>
												<a class="next" aria-label="Next" href="javascript:void(0)" onclick="page(<%= nextPageMessage %>)" data-category="pesan">Selanjutnya</a>
												<a class="next-mobile" aria-label="Next" href="javascript:void(0)" onclick="page(<%= nextPageMessage %>)" data-category="pesan"><i class="fas fa-chevron-right"></i></a>
											<% } else { %>
												<a class="disabled next" aria-label="Next" href="javascript:void(0)" onclick="page(<%= nextPageMessage %>)" data-category="pesan">Selanjutnya</a>
												<a class="disabled next-mobile" aria-label="Next" href="javascript:void(0)" onclick="page(<%= nextPageMessage %>)" data-category="pesan"><i class="fas fa-chevron-right"></i></a>
											<% } %>
										</li>
									</ul>
								</nav>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<liferay-util:html-bottom outputKey="htmlbottom">
	<script>
		window.loadAgentNotificationDataURL = "<%= loadAgentNotificationData %>";
		window.host = "<%= host %>";
		window.rToken = "<%= renderToken %>";
		window.apToken = "<%= apiRequestToken %>";
	</script>
	<script src="<%= request.getContextPath() %>/notification/js/main.js" type="text/javascript"></script>
</liferay-util:html-bottom>