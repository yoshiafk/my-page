<%@ include file="../variables.jsp"%>
<%@ page import = "java.text.SimpleDateFormat" %>

<%
	List<MypageUserTimeline> timelines = null;
	if(mypageUser != null) {
		timelines = MypageUserTimelineLocalServiceUtil.getByMypageUserId(mypageUser.getMypageUserId());
	}
%>
<liferay-ui:success key="timeline-deleted-ok" message="Timeline deleted!" />
<liferay-ui:success key="timeline-added-ok" message="Timeline added!" />
<liferay-ui:error key="timeline-deleted-no" message="Unable to delete timeline!" />

<div class="container-fluid container-fluid-max-xl container-view">
	<div class="row">
		<div class="col-lg-3">
			<%@ include file="../left_menu.jsp"%>
		</div>
		<div class="col-lg-8">
            <aui:form action="<%=addUserURL%>" enctype="multipart/form-data" name="user">
            	<clay:sheet>
            		<clay:sheet-header>
						<h2 class="sheet-title">
	                        <div class="row">
	                            <div class="col-lg-10">
	                                <div class="d-flex">
	                                    <span class="pl-2 text-truncate text-capitalize"><%= pageKey.replace("_", " ") %></span>
	                                </div>
	                            </div>
	                        </div>
	                    </h2>
					</clay:sheet-header>
            		<clay:sheet-section>
						<h3 class="sheet-subtitle">Perbaharui Status Anda</h3>
						<div id="Content">
							<aui:row>
							    <aui:col width="100">
							        <liferay-ui:input-editor cssClass="product-admin-editor"
							            editorName="ckeditor"
							            name="timelineText" 
							            showSource="false" 
							        />
							    </aui:col>
							</aui:row>
						</div>
		        		<%
		                    if (liferayUser != null) {
		                %>
		                <aui:input type="hidden" name="liferayUserId"
		                    value="<%=String.valueOf(liferayUser.getUserId())%>" />
		                <%
		                    }
		                %>
		                
		                <%
		                    if (liferayUser != null) {
		                %>
		                <aui:input type="hidden" name="mypageUserId"
		                    value="<%=String.valueOf(mypageUser.getMypageUserId())%>" />
		                <%
		                    }
		                %>
		                
		                <aui:input type="hidden" name="pageKey" value="<%= pageKey %>" />
		
		                <aui:button-row>
		                    <aui:button name="submitButton" type="submit" value="Save" />
		                </aui:button-row>
            		</clay:sheet-section>
            	</clay:sheet>

			</aui:form>
			
			<portlet:renderURL var="timelineURL">
				<portlet:param name="mvcPath" value="/user/edit.jsp" />
				<portlet:param name="pageKey" value="timeline" />
				<portlet:param name="mypageUserId" value="<%= String.valueOf(mypageUserId) %>" />
			</portlet:renderURL>
			<%
				if(timelines != null) {
					SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy");
					int num = 1;
					String tanggal="";
					for(MypageUserTimeline timeline : timelines) {
						tanggal = sdf.format(timeline.getCreateDate());
			%>
			<portlet:actionURL name="/mypageuser/update_data" var="deleteTimelineURL">
			    <portlet:param name="entryId" value="<%= String.valueOf(timeline.getMypageUserTimelineId()) %>" />
			    <portlet:param name="cmd" value="deleteTimeline" />
			    <portlet:param name="redirect" value="<%= timelineURL %>" />
			</portlet:actionURL>
			<clay:sheet cssClass="mt-2">
				<clay:sheet-section>
					<aui:row>
						<aui:col width="50" cssClass="">
							<strong><%= tanggal %></strong>
						</aui:col>
						<aui:col width="50" cssClass="text-right">
							<aui:button type="button" href="${deleteTimelineURL}" value="Remove"></aui:button>
						</aui:col>
						<aui:col width="100">
							<%= timeline.getText() %>
						</aui:col>
					</aui:row>
				</clay:sheet-section>
			</clay:sheet>
			<%
						num++;
					}
				}
			%>
		</div>
	</div>
</div>