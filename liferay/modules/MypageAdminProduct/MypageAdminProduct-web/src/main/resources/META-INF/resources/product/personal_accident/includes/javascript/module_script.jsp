<aui:script use="aui-base">
// PUBLISH
var publish = function () {
  if (confirm('<liferay-ui:message key="Are you sure?" />')) {
    var form = document.getElementById("<portlet:namespace />fm");

    if (form) {
      var cmd = form.querySelector("#<portlet:namespace /><%= Constants.CMD %>");

      if (cmd) {
        cmd.setAttribute("value", "<%= Constants.PUBLISH %>");
      }

      var entryIds = form.querySelector("#<portlet:namespace />entryIds");

      if (entryIds) {
        entryIds.setAttribute("value", Liferay.Util.listCheckedExcept(form, "<portlet:namespace />allRowIds"));
      }

      submitForm(form);
    }
  }
};


// UNPUBLISH
var unpublish = function () {
  if (confirm('<liferay-ui:message key="Are you sure?" />')) {
    var form = document.getElementById("<portlet:namespace />fm");

    console.log("#<portlet:namespace /><%= Constants.CMD %>");

    if (form) {
      var cmd = form.querySelector("#<portlet:namespace /><%= Constants.CMD %>");

      // Set CMD constants to REMOVE for Unpublish action
      if (cmd) {
        cmd.setAttribute("value", "<%= Constants.REMOVE %>");
      }

      var entryIds = form.querySelector("#<portlet:namespace />entryIds");

      if (entryIds) {
        entryIds.setAttribute("value", Liferay.Util.listCheckedExcept(form, "<portlet:namespace />allRowIds"));
      }

      submitForm(form);
    }
  }
};

// DELETE
var deleteItem = function () {
	conole.log("Delete action is not used");
  //   if (confirm('<liferay-ui:message key="Are you sure?" />')) {
  //     var form = document.getElementById("<portlet:namespace />fm");
  //     if (form) {
  //       var cmd = form.querySelector("#<portlet:namespace /><%= Constants.CMD %>");
  //       if (cmd) {
  //         cmd.setAttribute("value", "<%= Constants.DELETE %>");
  //       }
  //       var entryIds = form.querySelector("#<portlet:namespace />entryIds");
  //       console.log(Liferay.Util.listCheckedExcept(form, "<portlet:namespace />allRowIds"));
  //       if (entryIds) {
  //         entryIds.setAttribute("value", Liferay.Util.listCheckedExcept(form, "<portlet:namespace />allRowIds"));
  //       }
  //       submitForm(form);
  //     }
  //   }
};

// EXPORT MULTIPLE
var exportMultiple = function () {
  var exportForm = document.getElementById("<portlet:namespace />fmExport");
  var form = document.getElementById("<portlet:namespace />fm");

  var _allrowids = Liferay.Util.listCheckedExcept(form, "<portlet:namespace />allRowIds");

  if (form) {
    var cmd = exportForm.querySelector("#<portlet:namespace /><%=Constants.CMD%>");

    if (cmd) {
      cmd.setAttribute("value", "<%=Constants.EXPORT%>");
    }

    var entryIds = exportForm.querySelector("#<portlet:namespace />entryIds");

    if (entryIds) {
      entryIds.setAttribute("value", Liferay.Util.listCheckedExcept(form, "<portlet:namespace />allRowIds"));
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

Liferay.componentReady("<%=product%>ManagementToolbar").then(function (managementToolbar) {
  managementToolbar.on("actionItemClicked", function (event) {
    var itemData = "";
    if (typeof event.data.item.data != "undefined") {
      itemData = event.data.item.data;

      if (itemData && typeof itemData.action != "undefined") {
        if (ACTIONS[itemData.action]) {
          ACTIONS[itemData.action]();
        }
      }
    }
  });
});

</aui:script>