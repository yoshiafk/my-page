<%@ include file="../variables.jsp"%>

<%
	List<MypageUserWorkingHour> workingHours = null;
	if(mypageUser != null) {
		workingHours = MypageUserWorkingHourLocalServiceUtil.getByMypageUserId(mypageUser.getMypageUserId());
	}
%>

<h3 class="sheet-subtitle">Working Hour</h3>

<div id="working-hour">
	<%
		if(workingHours != null) {
			int num = 1;
			for(MypageUserWorkingHour workingHour : workingHours) {
	%>
	<aui:row>
		<aui:col width="25">
			<aui:select label="Day" name="workingHourDay[]" showEmptyOption="true">
				<% for(DayOfWeek day : DayOfWeek.values()) { %>
					   <aui:option value="<%= day.getDisplayName(TextStyle.FULL, Locale.US) %>" selected="<%= workingHour.getDay().equals(day.getDisplayName(TextStyle.FULL, Locale.US)) %>"><%= day.getDisplayName(TextStyle.FULL, Locale.US) %></aui:option>
				<% } %>
			</aui:select>
		</aui:col>
	
		<aui:col width="25">
			<aui:input cssClass="working-time" label="Start Time" name="workingHourStartDate[]" type="text" placeholder="hh:mm" value="<%= workingHour.getStartTime() %>" />
		</aui:col>
		<aui:col width="25">
			<aui:input cssClass="working-time" label="End Time" name="workingHourEndDate[]" type="text" placeholder="hh:mm" value="<%= workingHour.getEndTime() %>" />
		</aui:col>
		<aui:col width="25">
			<aui:row>
				<aui:col width="50">
					<aui:select label="Status" name="workingHourStatus[]">
						<aui:option value="1" selected="<%= workingHour.getStatus() == 1 %>">On</aui:option>
						<aui:option value="0" selected="<%= workingHour.getStatus() == 0 %>">Off</aui:option>
					</aui:select>
				</aui:col>
				<aui:col width="50">
					<label class="control-label d-block">&nbsp;</label>
					<aui:button type="button" onClick="removeWorkingHour(this)" value="Remove"></aui:button>
				</aui:col>
			</aui:row>
		</aui:col>
	</aui:row>
	<%
				num++;
			}
		}
	%>
</div>

<aui:row>
	<aui:col width="25">
		<aui:select label="Day" name="workingHourDay" showEmptyOption="true">
			<% for(DayOfWeek day : DayOfWeek.values()) { %>
				   <aui:option value="<%= day.getDisplayName(TextStyle.FULL, Locale.US) %>"><%= day.getDisplayName(TextStyle.FULL, Locale.US) %></aui:option>
			<% } %>
		</aui:select>
	</aui:col>

	<aui:col width="25">
		<aui:input cssClass="working-time" label="Start Time" name="workingHourStartDate" type="text" placeholder="hh:mm" />
	</aui:col>
	<aui:col width="25">
		<aui:input cssClass="working-time" label="End Time" name="workingHourEndDate" type="text" placeholder="hh:mm" />
	</aui:col>
	<aui:col width="25">
		<aui:row>
			<aui:col width="50">
				<aui:select label="Status" name="workingHourStatus">
					<aui:option value="1">On</aui:option>
					<aui:option value="0">Off</aui:option>
				</aui:select>
			</aui:col>
			<aui:col width="50">
				<label class="control-label d-block">&nbsp;</label>
				<aui:button type="button" onClick="addWorkingHour()" value="Add"></aui:button>
			</aui:col>
		</aui:row>
	</aui:col>
</aui:row>

<aui:script>
	function addWorkingHour() {
		var id = Date.parse(new Date());
		var wrap = document.getElementById('working-hour');
		var working = document.createElement("div");
		var workingHourDay = document.getElementById('<portlet:namespace />workingHourDay');
		var workingHourStartDate = document.getElementById('<portlet:namespace />workingHourStartDate');
		var workingHourEndDate = document.getElementById('<portlet:namespace />workingHourEndDate');
		var workingHourStatus = document.getElementById('<portlet:namespace />workingHourStatus');
		var daysArr = new Array(
					  "Sunday",
					  "Monday",
					  "Tuesday",
					  "Wednesday",
					  "Thursday",
					  "Friday",
					  "Saturday"
				  );
		var days = '<option value=""></option>';
		for(var i=0; i < 7; i++) {
			var selected = "";
			if(workingHourDay.value == daysArr[i]) selected = 'selected="selected"';
			days += '<option value="'+daysArr[i]+'" '+ selected +'>'+ daysArr[i] +'</option>';
		}
		var status = ""
		if(workingHourStatus.checked) status = 'checked="true"';
		var html = `
			<aui:row>
        		<aui:col width="25">
        			<div class="form-group input-select-wrapper">
        				<label class="control-label">Day</label>
	                    <select class="form-control" name="<portlet:namespace />workingHourDay[]">
	                    	`+days+`
	                    </select>
        			</div>
                </aui:col>
        	
                <aui:col width="25">
                	<aui:input cssClass="working-time" label="Start Time" name="workingHourStartDate[]" type="text" placeholder="hh:mm" value="`+workingHourStartDate.value+`" />
                </aui:col>
                <aui:col width="25">
                	<aui:input cssClass="working-time" label="Start Time" name="workingHourEndDate[]" type="text" placeholder="hh:mm" value="`+workingHourEndDate.value+`" />
                </aui:col>
                <aui:col width="25">
                	<aui:row>
	                	<aui:col width="50">
							<div class="form-group input-select-wrapper">
		        				<label class="control-label">Status</label>
			                    <select class="form-control" name="<portlet:namespace />workingHourStatus[]">
			                    	<option value="1">On</option>
			                    	<option value="0">Off</option>
			                    </select>
		        			</div>
		                </aui:col>
		                <aui:col width="50">
		                	<label class="control-label d-block">&nbsp;</label>
		                    <aui:button type="button" onClick="removeWorkingHour(this)" value="Remove"></aui:button>
		                </aui:col>
		        	</aui:row>
                </aui:col>
            </aui:row>
		`;
		working.innerHTML = html;

		wrap.appendChild(working);
		
		workingHourDay.value = "";
		workingHourStartDate.value = "";
		workingHourEndDate.value = "";
		workingHourStatus.checked = false;
	}
	
	function removeWorkingHour(e) {
		e.parentElement.parentElement.parentElement.parentElement.remove()
	}
</aui:script>

<aui:script use="aui-base">
	YUI().use(
	  'aui-timepicker',
	  function(Y) {
	    new Y.TimePicker(
	      {
	        trigger: '.working-time',
	        popover: {
	          zIndex: 1
	        },
	        on: {
	          selectionChange: function(event) {
	          
	          }
	        }
	      }
	    );
	  }
	);
</aui:script>