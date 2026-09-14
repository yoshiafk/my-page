<%@ include file="../variables.jsp"%>

<liferay-ui:error exception="<%= UserPasswordException.MustNotBeEqualToCurrent.class %>" message="your-new-password-cannot-be-the-same-as-your-old-password-please-enter-a-different-password" />
<liferay-ui:error exception="<%= UserPasswordException.MustNotBeNull.class %>" message="the-password-cannot-be-blank" />
<liferay-ui:error exception="<%= UserPasswordException.MustNotBeRecentlyUsed.class %>" message="that-password-has-already-been-used-please-enter-a-different-password" />
<liferay-ui:error exception="<%= UserPasswordException.MustNotBeTrivial.class %>" message="that-password-uses-common-words-please-enter-a-password-that-is-harder-to-guess-i-e-contains-a-mix-of-numbers-and-letters" />
<liferay-ui:error exception="<%= UserPasswordException.MustNotContainDictionaryWords.class %>" message="that-password-uses-common-dictionary-words" />

<h3 class="sheet-subtitle">Password</h3>

<aui:row>
    <aui:col width="100">
        <aui:input label="New Password" name="password" type="password" value="" autocomplete="new-password" required="<%= true %>" />
    </aui:col>
    <aui:col width="100">
        <aui:input label="Enter Again" name="password" type="password" value="" required="<%= true %>">
        	<aui:validator name="equalTo">
				'#<portlet:namespace />password'
			</aui:validator>
        </aui:input>
    </aui:col>
</aui:row>