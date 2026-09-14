<%@ include file="../variables.jsp"%>

<h3 class="sheet-subtitle">Social Media</h3>

<aui:row>
    <aui:col width="50">
        <aui:input label="Facebook" name="facebook" type="text"
            value="<%= mypageUser != null ? mypageUser.getFacebook() : "" %>" />
    </aui:col>
    <aui:col width="50">
        <aui:input label="Google Plus" name="googlePlus" type="text"
            value="<%= mypageUser != null ? mypageUser.getGooglePlus() : "" %>" />
    </aui:col>
</aui:row>

<aui:row>
    <aui:col width="50">
        <aui:input label="Twitter" name="twitter" type="text"
            value="<%= mypageUser != null ? mypageUser.getTwitter() : "" %>" />
    </aui:col>
    <aui:col width="50">
        <aui:input label="LinkedIn" name="linkedIn" type="text"
            value="<%= mypageUser != null ? mypageUser.getLinkedIn() : "" %>" />
    </aui:col>
</aui:row>

<aui:row>
    <aui:col width="50">
        <aui:input label="blog" name="blog" type="text"
            value="<%= mypageUser != null ? mypageUser.getBlog() : "" %>" />
    </aui:col>
    <aui:col width="50">
        <aui:input label="Whatsapp" name="whatsapp" type="text"
            value="<%= mypageUser != null ? mypageUser.getWhatsapp() : "" %>" />
    </aui:col>
</aui:row>

<aui:row>
    <aui:col width="50">
        <aui:input label="Skype" name="skype" type="text"
            value="<%= mypageUser != null ? mypageUser.getSkype() : "" %>" />
    </aui:col>
</aui:row>