<%@ include file="variables.jsp"%>
<%
	portletDisplay.setShowBackIcon(true);
	portletDisplay.setURLBack(userURL.toString());
	if(mypageUser != null) {
		renderResponse.setTitle(liferayUser.getFirstName() + " " + liferayUser.getLastName());
	}
%>	
<% if(pageKey.equals("timeline")){ %>
<liferay-util:include 
	page="<%= "/user/pages/" + pageKey + ".jsp" %>" 
	servletContext="<%= application %>"
/>	
<% return; } %>

<liferay-ui:success key="success" message="Your request completed successfully." />

<div class="container-fluid container-fluid-max-xl container-view">
	<div class="row">
		<div class="col-lg-3">
			<%@ include file="left_menu.jsp"%>
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
	                            <c:if test="<%= allowAdd %>">  
		                            <div class="col-lg-2">
		                                <aui:input checked="<%= mypageUser != null ? mypageUser.getActive() == 1 ? true : false : true %>" name="active"
		                                    type="toggle-switch" value="1" label="Active"
		                                    wrapperCssClass="leftToggleTitle" />
		                            </div>
		                    	</c:if>
	                        </div>
	                    </h2>
					</clay:sheet-header>
            	
            		<clay:sheet-section>
            			<liferay-util:include 
						  page="<%= "/user/pages/" + pageKey + ".jsp" %>" 
						  servletContext="<%= application %>"
						/>
            		</clay:sheet-section>
            	</clay:sheet>
        		
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
                    <aui:button type="cancel" onClick="<%=userURL.toString()%>"></aui:button>
                </aui:button-row>
            </aui:form>
        </div>
	</div>
</div>
