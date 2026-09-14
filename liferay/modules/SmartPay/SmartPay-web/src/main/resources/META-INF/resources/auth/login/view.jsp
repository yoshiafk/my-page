<%@ include file="../../init.jsp" %>
<%@ taglib uri="http://liferay.com/tld/captcha" prefix="liferay-captcha" %>

<%@ include file="../../includes/header_login.jsp" %>

<portlet:resourceURL id="verifycaptcha" var="verifyCaptchaURL" />

<div class="login" data-namespace="<portlet:namespace />">
    <div class="login-wrapper">
        <div class="login-wrapper__style-bg-img">
            <div class="container-axa">
                <div class="login-wrapper__container">
                    <div class="col-visible"></div>
                    <div class="login-wrapper__form">
                        <div class="pt-25px px-30px">
                            <h3>Masuk</h3>
                        </div>
                        <aui:form id="myform" action="javascript:;" method="post" name="fm">
                            <div class="login-form__body p-0px-30px-30px-30px">
                                <div id="login-nop-id-failed" class="alert failed error-text-wrapper align-text-center display-none"></div>
                                <div class="alert-login display-none">
									<span></span>
								</div>
                                <div class="mb-15px">
                                    <label class="display-block" for="no_polis">No Polis</label>
                                    <input name="no_polis" class="input-control input-control--outline color-bg-transparent" type="text" id="no_polis" placeholder="Masukkan No Polis" autocomplete="off">
                                </div>
                                <div class="mb-15px">
                                    <label class="display-block" for="id_profile">ID Profile</label>
                                    <input name="id_profile" class="input-control input-control--outline color-bg-transparent" type="text" id="id_profile" placeholder="Masukkan ID Profile" autocomplete="off">
                                </div>
                                <div class="login-form__captcha">
                                	<liferay-captcha:captcha />
                                </div>
                            </div>
                            <div class="login-form__footer">
                                <div>&nbsp;</div>
                                <button type="button" class="btn btn--dark-blue align-self-center">
                                    <span class="position-relative order-10">Lanjutkan <i class="fas fa-arrow-right fa-fw ml-5px"></i></span>
                                </button>
                            </div>
                        </aui:form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Modal Loading -->
<div class="modal modal-loading width-full fade" id="ModalLoading" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" style="display: none;" aria-labelledby="ModalLoadingLabel" aria-hidden="true">
	<div class="modal-dialog modal-loading-dialog modal-max-w-360px modal-loading-dialog-centered">
		<div class="modal-content modal-loading-content">
			<div class="modal-loading-body align-text-center p-100px-40px-100px-40px position-relative">
				<img class="w-75px display-block m-x-auto" src="<%= request.getContextPath() %>/includes/images/loading-1.gif" />
			</div>
		</div>
	</div>
</div>

<liferay-util:html-bottom outputKey="htmlbottom">
	<script>window.verifyCaptchaURL = "<%= verifyCaptchaURL %>";</script>
	<script src="<%= request.getContextPath() %>/auth/login/js/main.js" type="text/javascript"></script>
</liferay-util:html-bottom>