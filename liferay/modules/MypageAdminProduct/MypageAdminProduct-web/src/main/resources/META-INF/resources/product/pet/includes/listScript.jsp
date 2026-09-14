<aui:script use="aui-base">
		var publish = function() {
		if ( confirm('<liferay-ui:message key="Are you sure?" />')) {
			var form = document.getElementById('<portlet:namespace />fm');

			if (form) {
				var cmd = form.querySelector(
					'#<portlet:namespace /><%= Constants.CMD %>'
				);

				if (cmd) {
					cmd.setAttribute('value', '<%= Constants.PUBLISH %>');
				}

				var entryIds = form.querySelector(
					'#<portlet:namespace />entryIds'
				);

				if (entryIds) {
					entryIds.setAttribute(
						'value',
						Liferay.Util.listCheckedExcept(
							form,
							'<portlet:namespace />allRowIds'
						)
					);
				}

				submitForm(form);
			}
		}
	};
	
var unpublish = function() {
		if (confirm('<liferay-ui:message key="Are you sure?" />')) {
			var form = document.getElementById('<portlet:namespace />fm');
			
			if (form) {
				var cmd = form.querySelector('#<portlet:namespace /><%= Constants.CMD %>');

				if (cmd) {
					cmd.setAttribute('value', '<%= Constants.REMOVE %>');
				}

				var entryIds = form.querySelector('#<portlet:namespace />entryIds');

				if (entryIds) {
					entryIds.setAttribute(
						'value',
						Liferay.Util.listCheckedExcept(
							form,
							'<portlet:namespace />allRowIds'
						)
					);
				}

				submitForm(form);
			}
		}
	};
	
		// Delete
		var deleteItem = function() {
		if (confirm('<liferay-ui:message key="Are you sure?" />')) {
			var form = document.getElementById('<portlet:namespace />fm');

			if (form) {
				var cmd = form.querySelector(
					'#<portlet:namespace /><%= Constants.CMD %>'
				);

				if (cmd) {
					cmd.setAttribute('value', '<%= Constants.DELETE %>');
				}

				var entryIds = form.querySelector(
					'#<portlet:namespace />entryIds'
				);
				
				//console.log( Liferay.Util.listCheckedExcept(form,'<portlet:namespace />allRowIds') );

				if (entryIds) {
					entryIds.setAttribute(
						'value',
						Liferay.Util.listCheckedExcept(
							form,
							'<portlet:namespace />allRowIds'
						)
					);
				}

				submitForm(form);
			}
		}
	};
	
	var exportMultiple = function() {
	
			var exportForm = document.getElementById('<portlet:namespace />fmExport');
			var form = document.getElementById('<portlet:namespace />fm');
			
			var _allrowids = Liferay.Util.listCheckedExcept(form,'<portlet:namespace />allRowIds');
			
			if (form) {
				var cmd = exportForm.querySelector(
					'#<portlet:namespace /><%=Constants.CMD%>'
				);

				if (cmd) {
					cmd.setAttribute('value', '<%=Constants.EXPORT%>');
				}

				var entryIds = exportForm.querySelector(
					'#<portlet:namespace />entryIds'
				);

				if (entryIds) {
					entryIds.setAttribute(
						'value',
						Liferay.Util.listCheckedExcept(
							form,
							'<portlet:namespace />allRowIds'
						)
					);
				}
				
				submitForm(exportForm);
			}
	};
	
	var ACTIONS = {
		publish: publish,
		unpublish: unpublish,
		deleteItem: deleteItem,
		exportMultiple: exportMultiple,
	};
	
	Liferay.componentReady('<%=product%>ManagementToolbar').then(
	function(managementToolbar) {
	console.log(managementToolbar);
		managementToolbar.on('actionItemClicked', function(event) {
			var itemData = event.data.item.data;

			if (itemData && itemData.action && ACTIONS[itemData.action]) {
				ACTIONS[itemData.action]();
			}
		});
	});
	
	var controlMenu = A.one('#<portlet:namespace />ControlMenu');
	var exportImport = controlMenu.one('span[title="Export All Data"]');
	if(exportImport != null) {	
		exportImport.on('click',function(){
			if ( confirm( '<liferay-ui:message key="Are you sure to export all data?" />')) {	
				var fmExport = document.getElementById('<portlet:namespace />fmExport');
				var form = document.getElementById('<portlet:namespace />fm');
				if (form) {
					var cmd = fmExport.querySelector('#<portlet:namespace /><%= Constants.CMD %>');
	
					if (cmd) {
						cmd.setAttribute('value', 'exportAll');
					}
					
					submitForm(fmExport);
				}		
			
			}
		});
	}
</aui:script>