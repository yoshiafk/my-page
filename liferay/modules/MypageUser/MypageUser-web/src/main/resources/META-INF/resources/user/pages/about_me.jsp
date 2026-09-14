<%@ include file="../variables.jsp"%>

<h3 class="sheet-subtitle">Personal Information</h3>

<aui:row>
    <aui:col width="50">
        <aui:input label="My Title" name="myTitle" type="text"
            value="<%= mypageUser != null ? mypageUser.getMyTitle() : "" %>" />
    </aui:col>
    <aui:col width="50">
        <aui:input label="My Video" name="myVideo" type="url"
            value="<%= mypageUser != null ? mypageUser.getMyVideo() : "" %>" />
    </aui:col>
    <aui:col width="100">
        <liferay-ui:input-editor cssClass="product-admin-editor"
            editorName="ckeditor"
            name="aboutMe" 
            showSource="true"
            contents="<%= mypageUser != null ? mypageUser.getAboutMe() : "" %>" 
        />
    </aui:col>
</aui:row>