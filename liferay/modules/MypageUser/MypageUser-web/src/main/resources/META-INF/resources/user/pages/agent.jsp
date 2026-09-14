<%@ include file="../variables.jsp"%>

<h3 class="sheet-subtitle">Agent Information</h3>

<aui:row>
    <aui:col width="50">
        <aui:input label="Code" name="code" type="text"
            value="<%= mypageUser != null ? mypageUser.getCode() : "" %>" />
    </aui:col>
</aui:row>

<aui:row>
    <aui:col width="50">
        <aui:select label="Agent Flag" name="agentFlag" showEmptyOption="true">
            <aui:option value="GI" selected="<%= mypageUser != null && mypageUser.getAgentFlag().equals("GI") %>">GI</aui:option>
            <aui:option value="AFI" selected="<%= mypageUser != null && mypageUser.getAgentFlag().equals("AFI") %>">AFI</aui:option>
            <aui:option value="AIC" selected="<%= mypageUser != null && mypageUser.getAgentFlag().equals("AIC") %>">AIC</aui:option>
            <aui:option value="LIFE" selected="<%= mypageUser != null && mypageUser.getAgentFlag().equals("LIFE") %>">LIFE</aui:option>
        </aui:select>
    </aui:col>
    
    <aui:col width="50">
        <aui:input label="Branch" name="branch" type="text"
            value="<%= mypageUser != null ? mypageUser.getBranch() : "" %>" />
    </aui:col>
</aui:row>

<aui:row>
    <aui:col width="50">
        <aui:input label="Promo Code" name="promoCode" type="text"
            value="<%= mypageUser != null ? mypageUser.getPromoCode() : "" %>" />
    </aui:col>
    <aui:col width="50">
        <aui:input label="AGS Promo Code" name="agsPromoCode" type="text"
            value="<%= mypageUser != null ? mypageUser.getAgsPromoCode() : "" %>" />
    </aui:col>
</aui:row>

<aui:row>
    <aui:col width="50">
        <aui:input label="Deptore Code" name="deptoreCode" type="text"
            value="<%= mypageUser != null ? mypageUser.getDeptoreCode() : "" %>" />
    </aui:col>
    <aui:col width="50">
        <aui:input label="Leader" name="leader" type="text"
            value="<%= mypageUser != null ? mypageUser.getLeader() : "" %>" />
    </aui:col>
</aui:row>

<aui:row>
    <aui:col width="50">
        <aui:input label="Status Agent" name="statusAgent" type="text"
            value="<%= mypageUser != null ? mypageUser.getStatusAgent() : "" %>" />
    </aui:col>
    <aui:col width="50">
        <aui:input label="License Number" name="licenseNumber" type="text"
            value="<%= mypageUser != null ? mypageUser.getLicenseNumber() : "" %>" />
    </aui:col>
</aui:row>

<aui:row cssClass="pb-4">
    <aui:col width="50">
        <%
            Integer dayJD = null;
            Integer monthJD = null;
            Integer yearJD = null;
            
            if(mypageUser != null && String.valueOf(mypageUser.getJoinDate()) != "" && String.valueOf(mypageUser.getJoinDate()) != "null") {
                SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
                LocalDate Dob = LocalDate.parse(date.format(mypageUser.getJoinDate()));
            
                dayJD = Dob.getDayOfMonth();
                monthJD = Dob.getMonthValue() - 1;
                yearJD = Dob.getYear();
            }
        %>
        <aui:row>
            <aui:col width="100">
                <label>Join Date</label>
            </aui:col>
            <aui:col width="100">
                <% if(mypageUser != null && String.valueOf(mypageUser.getJoinDate()) != "" && String.valueOf(mypageUser.getJoinDate()) != "null") { %>
                <liferay-ui:input-date 
                    name="joinDate"
                    dayValue="<%= dayJD %>" 
                    monthValue="<%= monthJD %>"
                    yearValue="<%= yearJD %>" 
                />
                <% } else { %>
                <liferay-ui:input-date 
                    name="joinDate"
                    nullable="true"
                    showDisableCheckbox="false"
                />
                <% } %>
            </aui:col>
        </aui:row>
    </aui:col>
    <aui:col width="50">
        <%
            Integer dayED = null;
            Integer monthED = null;
            Integer yearED = null;
            
            if(mypageUser != null && String.valueOf(mypageUser.getEndDate()) != "" && String.valueOf(mypageUser.getEndDate()) != "null") {
                SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
                LocalDate Dob = LocalDate.parse(date.format(mypageUser.getEndDate()));
            
                dayED = Dob.getDayOfMonth();
                monthED = Dob.getMonthValue() - 1;
                yearED = Dob.getYear();
            }
        %>
        <aui:row>
            <aui:col width="100">
                <label>End Date</label>
            </aui:col>
            <aui:col width="100">
                <% if(mypageUser != null && String.valueOf(mypageUser.getEndDate()) != "" && String.valueOf(mypageUser.getEndDate()) != "null") { %>
                <liferay-ui:input-date 
                    name="endDate"
                    dayValue="<%= dayED %>" 
                    monthValue="<%= monthED %>"
                    yearValue="<%= yearED %>" 
                />
                <% } else { %>
                <liferay-ui:input-date 
                    name="endDate"
                    nullable="true"
                    showDisableCheckbox="false"
                />
                <% } %>
            </aui:col>
        </aui:row>
    </aui:col>
</aui:row>

<aui:row>
    <aui:col width="50">
        <aui:input label="Pretty Url" name="prettyUrl" type="text"
            value="<%= mypageUser != null ? mypageUser.getPrettyUrl() : "" %>" />
    </aui:col>
    <aui:col width="50">
        <aui:input label="Pretty Url Change" name="prettyUrlChange" type="number"
            value="<%= mypageUser != null ? mypageUser.getPrettyUrlChange() : "" %>" />
    </aui:col>
</aui:row>

<aui:row>
    <aui:col width="50">
        <aui:input label="Tax Rate" name="taxRate" type="text"
            value="<%= mypageUser != null ? mypageUser.getTaxRate() : "" %>" />
    </aui:col>
    <aui:col width="50">
        <aui:input label="Visited Count" name="visitedCount" type="number"
            value="<%= mypageUser != null ? mypageUser.getVisitedCount() : "" %>" />
    </aui:col>
</aui:row>

<aui:row>
    <aui:col width="50">
        <aui:input label="Partnership Name" name="partnershipName" type="text"
            value="<%= mypageUser != null ? mypageUser.getPartnershipName() : "" %>" />
    </aui:col>
    <aui:col width="100">
        <aui:input label="Is Partnership" name="isPartnership" type="checkbox"
            value="1" checked="<%=mypageUser != null && mypageUser.getIsPartnership() == 1 %>" />
    </aui:col>
</aui:row>