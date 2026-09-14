<%@ include file="../includes/init.jsp"%>

<div class="container-fluid container-fluid-max-xl container-view">
  <div class="row">
      <div class="col-lg-3">
		<%
			String _active = "promocode";
		%>      
	  	<%@ include file="../includes/left-menu.jsp"%>
      </div>
      <div class="col-lg-9">
		<portlet:actionURL name="importPromocode" var="importPromocodeURL" />
		<aui:form method="post" action="<%= importPromocodeURL %>" enctype="multipart/form-data" name="<portlet:namespace />fm">
			<div class="sheet sheet-full">
				<div class="row">
					<div class="col-md-6">
						<h2 class="sheet-title">
							<div class="d-flex">
								<aui:icon cssClass="" image="tag" markupView="lexicon" />	                    
			                   	<span class="pl-2 text-truncate">Import Promo Code</span>
							</div>
						</h2>
					</div>
				</div>
			</div>
			<div class="sheet-section">
				<aui:fieldset-group markupView="lexicon">
					<aui:fieldset cssClass="pt-4 pl-4">			
						<aui:row>			
							<aui:col width="50">
							    <aui:input label="Promocode" name="promocode" type="text" required="true" />
							    <aui:button type="submit" name="btnImport" value="Import"></aui:button>
							</aui:col>
						</aui:row>
					</aui:fieldset>
				</aui:fieldset-group>
			</div>
		</aui:form>      
      </div>
  </div>
</div>