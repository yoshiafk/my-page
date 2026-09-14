<%@ include file="../includes/init.jsp"%>

<%
    // Display Context
    MasterDisplayContext masterDisplayContext = new MasterDisplayContext(liferayPortletRequest,
            liferayPortletResponse);

    // Search Container
    SearchContainer entriesPromocodes = masterDisplayContext.promocodesSearchContainer();

    // Management Toolbar Display Context
    MasterManagementToolbarDisplayContext masterManagementToolbarDisplayContext = new MasterManagementToolbarDisplayContext(
            request, liferayPortletRequest, liferayPortletResponse, entriesPromocodes);

    PortletURL iteratorURL = masterManagementToolbarDisplayContext._getCurrentSortingURL();

    // Variable to include in javascript
    String product = "promocodesSearchContainer";
%>

<portlet:actionURL name="/masterdata/update_data" var="updateURL" />

<liferay-ui:success key="dataAdded" message="data-added" />
<liferay-ui:success key="dataUpdated" message="data-updated" />

<div class="container-fluid container-fluid-max-xl container-view">
    <div class="row">

        <div class="col-lg-3">
            <%
                String _active = "promocode";
                final String _editPromocodeURL = editPromocodeURL;
            %>

            <%@ include file="../includes/left-menu.jsp"%>
        </div>
        <div class="col-lg-9">
            <div class="sheet sheet-full">

                <!-- TITLE -->
                <h2 class="sheet-title">
                    <div class="d-flex">
                        <aui:icon cssClass="" image="tag" markupView="lexicon" />
                        <span class="pl-2 text-truncate">Promo Code</span>
                    </div>
                </h2>
                

                <!--  COLLAPSIBLE PANEL -->
                <liferay-ui:panel collapsible="true" cssClass="p-3"
                    defaultState="<%=masterDisplayContext._getOnSearch() ? "open" : "collapsed"%>"
                    extended="false" title="Search" iconCssClass="icon-search">

                    <aui:form name="search"
                        action="<%=masterManagementToolbarDisplayContext._getSearchActionURL()%>"
                        method="post">
                        <liferay-ui:panel-container extended="false"
                            id="innerPanelContainer">
                            <aui:row>
                                <aui:col width="25">
                                    <aui:input label="Promo Code" name="s_promocode" type="text" />
                                </aui:col>
                            </aui:row>
                            <aui:button-row>
                                <aui:button name="s_reset" type="reset"
                                    value="Reset" href="<%=promocodeURL%>" primary="true"
                                    icon="icon-repeat" />
                                <aui:button name="s_search" type="submit"
                                    value="Search" />
                            </aui:button-row>
                        </liferay-ui:panel-container>
                    </aui:form>
                </liferay-ui:panel>
                <!--  COLLAPSIBLE PANEL -->

                <!--  MANAGEMENT TOOLBAR -->
                <clay:management-toolbar supportsBulkActions="<%=true%>"
                    searchContainerId="promocodesSearchContainer"
                    displayContext="<%=masterManagementToolbarDisplayContext%>" />
                <!--  MANAGEMENT TOOLBAR -->

                <portlet:resourceURL var="exportPromocodesURL">
                    <portlet:param name="exportPromocode"
                        value="exportPromocode" />
                </portlet:resourceURL>

                <aui:form action="<%=exportPromocodesURL%>" name="fmExport">
                    <aui:input name="<%=Constants.CMD%>" type="hidden" />
                    <aui:input name="redirect" type="hidden"
                        value="<%=iteratorURL.toString()%>" />
                    <aui:input name="entryIds" type="hidden" />
                    <aui:input name="type" value="promocode" type="hidden" />
                </aui:form>

                <aui:form action="<%=updateURL%>" name="fm">
                    <aui:input name="<%=Constants.CMD%>" type="hidden" />
                    <aui:input name="redirect" type="hidden" value="<%=promocodeURL%>" />
                    <aui:input name="entryIds" type="hidden" />
                    <aui:input name="type" type="hidden" value="promocode" />

                    <!-- SEARCH CONTAINER -->
                    <liferay-ui:search-container id="promocodesSearchContainer"
                        searchContainer="<%=entriesPromocodes%>">

                        <liferay-ui:search-container-row
                            className="com.mypage.admin.product.model.MasterPromoCode"
                            modelVar="MasterPromoCode" keyProperty="promocodeId">

                            <portlet:renderURL var="rowURL">
                                <portlet:param name="mvcPath" value="/master/promocode/edit.jsp" />
                                <portlet:param name="promocodeId"
                                    value="<%=String.valueOf(MasterPromoCode.getPromoCodeId())%>" />
                            </portlet:renderURL>

                            <%
                                String classInactive = MasterPromoCode.getActive() != 1 ? "status-inactive" : "status-active";
                            %>

                            <liferay-ui:search-container-column-text property="promoCodeId"
                                title="ID" name="ID" valign="middle"
                                cssClass="<%=classInactive%>" href="<%=rowURL%>" />

                            <liferay-ui:search-container-column-text property="promoCode"
                                title="promocode" name="promocode" valign="middle"
                                cssClass="<%=classInactive%>" />


                            <liferay-ui:search-container-column-jsp name="Action"
                                align="right" path="/master/promocode/action.jsp" />

                        </liferay-ui:search-container-row>
                        <liferay-ui:search-iterator markupView="lexicon" />
                    </liferay-ui:search-container>
                    <!-- SEARCH CONTAINER -->
                </aui:form>
            </div>
        </div>
        
        
        
    </div>
</div>

<%@ include file="../includes/listScript.jsp"%>