<%@ include file="../init.jsp"%>
<%
	long sppkUserId = ParamUtil.getLong(renderRequest, "sppkUserId", 0L);
	SppkUser sppkUser = null;
	if (sppkUserId > 0) {
		sppkUser = SppkUserLocalServiceUtil.fetchSppkUser(sppkUserId);
	}
%>

<%-- <liferay-ui:success key="dataUpdated" message="data-updated" /> --%>

<div class="container-fluid container-fluid-max-xl container-view">
	<div class="row">
		<div class="col-lg-12">
			<aui:form action="<%=addSppkUserURL%>" enctype="multipart/form-data"
				name="sppk_user">
				<clay:sheet>
					<clay:sheet-header>
						<h2 class="sheet-title">
							<div class="row">
								<div class="col-lg-8">
									<div class="d-flex">
										<aui:icon cssClass="" image="users" markupView="lexicon" />
										<span class="pl-2 text-truncate"><%=sppkUserId > 0 ? "Edit SPPK User" : "Add SPPK User"%></span>
									</div>
								</div>
								<div class="col-lg-4">
									<aui:input
										checked="<%=sppkUserId != 0 && sppkUser != null ? sppkUser.getActive() == 1 ? true : false : true%>"
										name="active" type="toggle-switch" value="1" label="Active"
										wrapperCssClass="leftToggleTitle" />
								</div>
							</div>
						</h2>
					</clay:sheet-header>

					<clay:sheet-section>
						<aui:row>
							<aui:col width="100">
								<aui:input label="Full Name" name="full_name" type="text"
									value="<%=sppkUser == null ? "" : String.valueOf(sppkUser.getFullName())%>" />
							</aui:col>
						</aui:row>
						<aui:row>
							<aui:col width="100">
								<aui:input label="Login Code" name="login_code" type="text"
									value="<%=sppkUser == null ? "" : String.valueOf(sppkUser.getSppkLoginCode())%>" />
							</aui:col>
						</aui:row>
						<aui:row>
							<aui:col width="100">
								<aui:input label="Password" name="password" type="password"
									value="<%=sppkUser == null ? "" : ""%>" />
							</aui:col>
						</aui:row>

						<aui:row>
							<aui:col width="100">
								<aui:input label="Email" name="email" type="text"
									value="<%=sppkUser == null ? "" : String.valueOf(sppkUser.getEmail())%>" />
							</aui:col>
						</aui:row>

						<%-- 						<aui:row>
							<aui:col width="100">
								<aui:select name="role_code" label="Role">
									<aui:option value="sales" label="Sales"
										selected="<%=(sppkUser != null && sppkUser.getRoleCode().equalsIgnoreCase("sales"))
											? true
											: false%>" />
									<aui:option value="rcc" label="RCC"
										selected="<%=(sppkUser != null && sppkUser.getRoleCode().equalsIgnoreCase("rcc")) ? true
													: false%>" />
								</aui:select>
							</aui:col>
						</aui:row> --%>

						<aui:row>
							<%-- 							<aui:col width="30">
								<%
									boolean allAccess = sppkUser != null && sppkUser.getAllAccess() == 1 ? true : false;
								%>
								<aui:input checked="<%=allAccess%>" name="all_access"
									type="toggle-switch" value="1" label="All Access" />
							</aui:col> --%>

							<aui:col width="30">
								<%
									boolean accessData = sppkUser != null && sppkUser.getAccessData() == 1 ? true : false;
								%>
								<aui:input checked="<%=accessData%>" name="access_data"
									type="toggle-switch" value="1" label="Access Data Debitur" />
							</aui:col>

							<aui:col width="30">
								<%
									boolean accessMonitoring = sppkUser != null && sppkUser.getAccessMonitoring() == 1
																? true
																: false;
								%>
								<aui:input checked="<%=accessMonitoring%>"
									name="access_monitoring" type="toggle-switch" value="1"
									label="Access Data SPPK" />
							</aui:col>
						</aui:row>

						<%
							if (sppkUser != null) {
						%>
						<aui:input type="hidden" name="sppkUserId"
							value="<%=String.valueOf(sppkUser.getSppkUserId())%>" />
						<%
							}
						%>

						<aui:button-row>
							<aui:button name="submitButton" type="submit" value="Save" />
							<aui:button type="cancel" onClick="<%=sppkUserUrl.toString()%>"></aui:button>
						</aui:button-row>
					</clay:sheet-section>
				</clay:sheet>
			</aui:form>
		</div>
	</div>
</div>
