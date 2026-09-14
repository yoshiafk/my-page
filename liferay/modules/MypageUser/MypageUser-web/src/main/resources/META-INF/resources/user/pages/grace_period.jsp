<%@ include file="../variables.jsp"%>

<%
	List<MypageUserGracePeriod> gracePeriods = null;
	if(mypageUser != null) {
		gracePeriods = MypageUserGracePeriodLocalServiceUtil.getByMypageUserId(mypageUser.getMypageUserId());
	}
%>

<h3 class="sheet-subtitle">Grace Period</h3>

<div id="grace-period">
    <%
        if(gracePeriods != null) {
            for(MypageUserGracePeriod gracePeriod : gracePeriods) {
    %>
    <aui:row>
        <aui:col width="50">
            <aui:row>
                <aui:col width="50">
                    <aui:input label="Product Code" name="gracePeriodCode[]" type="text" value="<%= gracePeriod.getCode() %>" />
                </aui:col>
                <aui:col width="50">
                    <aui:input label="Value" name="gracePeriodValue[]" type="text" value="<%= gracePeriod.getValue() %>">
                    	<aui:validator name="number" />
                    </aui:input>
                </aui:col>
            </aui:row>
        </aui:col>
        <aui:col width="50">
            <label class="control-label d-block">&nbsp;</label>
            <aui:button type="button" onClick="removeGracePeriod(this)" value="Remove"></aui:button>
        </aui:col>
    </aui:row>
    <%
            }
        }
    %>
</div>

<aui:row>
    <aui:col width="50">
        <aui:row>
            <aui:col width="50">
                <aui:input id="grace-period-code" label="Product Code" name="graceCode" type="text" />
            </aui:col>
            <aui:col width="50">
                <aui:input id="grace-period-value" label="Value" name="greaceValue" type="text">
                	<aui:validator name="number" />
                </aui:input>
            </aui:col>
        </aui:row>
    </aui:col>
    <aui:col width="50">
        <label class="control-label d-block">&nbsp;</label>
        <aui:button type="button" onClick="addGracePeriod()" value="Add"></aui:button>
    </aui:col>
</aui:row>

<aui:script>
	function addGracePeriod() {
		var wrap = document.getElementById('grace-period');
		var grace = document.createElement("div");
		var code = document.getElementById('<portlet:namespace />grace-period-code');
		var value = document.getElementById('<portlet:namespace />grace-period-value');
		
		if(code.value == "" || value.value == "") {
			return false;
		}
		
		var html = `
			<aui:row>
                <aui:col width="50">
                    <aui:row>
		                <aui:col width="50">
		                    <aui:input label="Product Code" name="gracePeriodCode[]" type="text" value="`+code.value+`" />
		                </aui:col>
		                <aui:col width="50">
		                    <aui:input label="Value" name="gracePeriodValue[]" type="text" value="`+value.value+`">
		                    	<aui:validator name="number" />
		                    </aui:input>
		                </aui:col>
		            </aui:row>
                </aui:col>
                <aui:col width="50">
                	<label class="control-label d-block">&nbsp;</label>
                    <aui:button type="button" onClick="removeGracePeriod(this)" value="Remove"></aui:button>
                </aui:col>
            </aui:row>
		`;
		grace.innerHTML = html;
		
		wrap.appendChild(grace);
		
		// reset
		code.value = "";
		value.value = "";
	}
	
	function removeGracePeriod(e) {
		e.parentElement.parentElement.remove()
	}
</aui:script>