<%@ include file="../includes/init.jsp"%>

<%
	long classRateId = ParamUtil.getLong(renderRequest, "classRateId", 0);
	SmartActiveClassRate classRate = null;
	
	if (classRateId > 0) {
		classRate = SmartActiveClassRateLocalServiceUtil.fetchSmartActiveClassRate(classRateId);
	}
%>

<div class="container-fluid container-fluid-max-xl container-view">
	<div class="row">
		<div class="col-lg-3">
			<%
				// setting for menu
				String _active = "class_rate";
			%>
			<%@ include file="../includes/left-menu.jsp"%>
		</div>
		<div class="col-lg-9">
			<aui:form action="<%= addClassRateURL %>" name="classRate">
				<div class="sheet sheet-full">

					<h2 class="sheet-title">
						<div class="row">
							<div class="col-lg-8">
								<div class="d-flex">
									<aui:icon cssClass="" image="categories" markupView="lexicon" />
									<span class="pl-2 text-truncate"><%= classRateId > 0 ? "Edit Class Rate" : "Add Class Rate" %></span>
								</div>
							</div>
							<div class="col-lg-4">
								<aui:input
									checked="<%= classRateId != 0 && classRate != null ? classRate.getActive() == 1 ? true : false : true %>"
									name="active" type="toggle-switch" value="1" label="Active"
									wrapperCssClass="leftToggleTitle" />
							</div>
						</div>
					</h2>

					<div class="sheet-section">
						<aui:fieldset-group markupView="lexicon">
							<aui:fieldset cssClass="pt-4 pl-4">

								<aui:row>
									<aui:col width="100">
										<aui:input label="Name (Indonesia)" name="nameId"
											type="text" required="true"
											value="<%= classRate == null ? "" : String.valueOf(classRate.getNameId()) %>" />
									</aui:col>
									
									<aui:col width="100">
										<aui:input label="Name (English)" name="nameEn"
											type="text" required="true"
											value="<%= classRate == null ? "" : String.valueOf(classRate.getNameEn()) %>" />
									</aui:col>
									
								</aui:row>
							</aui:fieldset>
						</aui:fieldset-group>

						<%
							if (classRate != null) {
						%>
						<aui:input type="hidden" name="classRateId" value="<%= String.valueOf(classRate.getSmartActiveClassRateId()) %>" />
						<%
							}
						%>

						<aui:button-row>
							<aui:button name="submitButton" type="submit" value="Save" />
							<aui:button type="cancel" onClick="<%= classRateURL.toString() %>"></aui:button>
						</aui:button-row>
			</aui:form>
		</div>
	</div>
</div>
