<%@ include file="/init.jsp"%>

<%
	LocalDateTime timestampForJSURI = LocalDateTime.now();
	DateTimeFormatter formatterForJSURI = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
	String numericTimestamptimestampForJSURI = timestampForJSURI.format(formatterForJSURI);
	String csrfToken = Optional.ofNullable((String) renderRequest.getAttribute("CSRF_TOKEN")).orElse("");
	Boolean isOtp = Optional.ofNullable((Boolean) renderRequest.getAttribute("ISOTP")).orElse(false);
	
	String userEmail = Optional.ofNullable((String) renderRequest.getAttribute("USEREMAIL")).orElse("");
	String emailMask = Optional.ofNullable((String) renderRequest.getAttribute("EMAILMASK")).orElse("");
%>

<portlet:resourceURL id="signinEntry" var="signinEntryURL" />
<portlet:resourceURL id="otpEntry" var="otpEntryURL" />
<portlet:resourceURL id="resendOtpEntry" var="resendOtpEntryURL" />

<%
	if (isOtp) {
%>
<script type="text/javascript">
document.body.classList.add("min-h-screen", "flex", "flex-col");
</script>

<div class="flex flex-col flex-grow justify-center items-center">
  <img class="h-[60px] mb-[20px]" src="<%=request.getContextPath() %>/images/logo_axa_mandiri.png" alt="" loading="lazy" />

  <div class="flex flex-col items-center text-center w-[400px] p-[40px] bg-[#fafafa] border border-[#ccc]">
    <div class="text-center">
      <h1 class="font-bold text-xl">Masukkan Kode Verifikasi</h1>
      <p class="text-[14px]">
        Kode verifikasi telah dikirimkan melalui email ke <br />
        <b><%=emailMask%></b>
      </p>
    </div>

    <form id="form-otp" class="w-full" method="post" action="#" autocomplete="off">
      <div class="grid grid-cols-5 gap-1 pt-[40px] pb-[60px]">
        <input
          type="text"
          maxlength="1"
          inputmode="numeric"
          class="otp-input mx-[10px] bg-transparent border-b-4 border-[#acacac] text-center text-[28px] font-bold focus:border-[#00008f] focus:outline-none"
          required=""
          autofocus=""
        />
        <input
          type="text"
          maxlength="1"
          inputmode="numeric"
          class="otp-input mx-[10px] bg-transparent border-b-4 border-[#acacac] text-center text-[28px] font-bold focus:border-[#00008f] focus:outline-none"
          required=""
        />
        <input
          type="text"
          maxlength="1"
          inputmode="numeric"
          class="otp-input mx-[10px] bg-transparent border-b-4 border-[#acacac] text-center text-[28px] font-bold focus:border-[#00008f] focus:outline-none"
          required=""
        />
        <input
          type="text"
          maxlength="1"
          inputmode="numeric"
          class="otp-input mx-[10px] bg-transparent border-b-4 border-[#acacac] text-center text-[28px] font-bold focus:border-[#00008f] focus:outline-none"
          required=""
        />
        <input
          type="text"
          maxlength="1"
          inputmode="numeric"
          class="otp-input mx-[10px] bg-transparent border-b-4 border-[#acacac] text-center text-[28px] font-bold focus:border-[#00008f] focus:outline-none"
          required=""
        />
      </div>

      <!-- OTP input -->
      <input id="otp-value" type="hidden" name="otp" required="" />
      <input type="hidden" name="user_email" value="<%=userEmail%>" id="user-email"/>
      <input type="hidden" name="csrfToken" value="<%=csrfToken%>" />

      <div class="body">
        <button id="btn-submit" class="btn btn--dark-blue inline-block text-center w-full p-12px-25px-10px-25px" type="submit" name="submit">Verifikasi</button>
      </div>
    </form>

    <form class="w-full" method="post" action="javascript:void(0)" id="resend-otp">
      <div class="text-[14px] text-right pt-[20px]">
        Tidak menerima kode verifikasi? <button id="resend" type="submit" name="submit"><b class="text-[#00008f]">Kirim ulang</b></button>
      </div>
    </form>
  </div>
</div>


<script src="<%=request.getContextPath()%>/js/otp.js?v=<%=numericTimestamptimestampForJSURI%>" type="text/javascript"></script>

<%
	} else {
%>

<script type="text/javascript">
document.body.classList.add("body-blue", "text-white", "text-base");

document.getElementById("content").classList.add(
  "relative",
  "mx-auto",
  "px-3",
  "w-full"
);
</script>
<div class="pt-16 lg:flex lg:h-[500px]">
	<div class="flex justify-center items-center lg:w-1/2">
		<img src="/o/aii-esppk-theme/images/main-logo-white.png"
			alt="axa-logo" class="w-24 lg:w-28">
	</div>
	<form class="login-form mt-20 lg:w-1/3" id="formLogin"
		action="javascript:void()" autocomplete="off" novalidate="novalidate">
		<div class="text-center my-6 lg:text-left lg:my-0 !mb-3">
			<span class="font-publico text-[22px] leading-10 font-bold;">Selamat
				datang di<br>SPPK Online AXA Insurance Indonesia
			</span>
		</div>
		<fieldset aria-label="Login" id="login"
			class="w-full break-words border-0 m-0 min-w-0 p-0">
			<input type="hidden" name="csrfToken" value="<%=csrfToken%>" />
			<div class="relative mb-6 input-text-wrapper">
				<label
					class="inline-block mb-2 max-w-full break-words cursor-pointer text-base text-white text-sm font-semibold"
					for="username">Username</label> <input
					class="field appearance-none bg-[#4976ba] border-white text-white rounded-none py-2 block w-full min-w-0 h-10 text-base font-normal leading-6 border border-solid px-4 placeholder:text-white transition-[border-color,box-shadow] duration-150 ease-in-out focus:border-[#80acff] focus:outline-none focus:bg-[#4976ba] focus:shadow-axa-shadow-click"
					id="username" name="username" placeholder="Masukkan username Anda"
					type="text" autocomplete="off" maxlength="50" required>
			</div>
			<div class="relative mb-6 input-text-wrapper">
				<label
					class="inline-block mb-2 max-w-full break-words cursor-pointer text-base text-white text-sm font-semibold"
					for="password">Kata Sandi</label> <input
					class="field appearance-none bg-[#4976ba] border-white text-white rounded-none py-2 block w-full min-w-0 h-10 text-base font-normal leading-6 border border-solid px-4 placeholder:text-white transition-[border-color,box-shadow] duration-150 ease-in-out focus:border-[#80acff] focus:outline-none focus:bg-[#4976ba] focus:shadow-axa-shadow-click"
					id="password" name="password"
					placeholder="Masukkan kata sandi Anda" type="password"
					autocomplete="off" maxlength="32" required>
			</div>
		</fieldset>
		<div class="relative h-[132px] w-full overflow-hidden lg:w-[425px]">
			<div id="next-action" class="absolute left-1 top-1 duration-500">
				<button id="btnLogin"
					class="inline-block font-semibold border-0 border-solid border-transparent text-sm py-4 px-6 uppercase tracking-[1px] rounded-none text-gray-800 bg-white border-white transition-[color,background-color,border-color,box-shadow] duration-150 ease-in-out shadow-axa-shadow-light hover:shadow-axa-shadow-hover-light active:text-gray-800 active:bg-white active:border-white active:shadow-axa-shadow-active-light focus:text-gray-800 focus:bg-white focus:border-white focus:shadow-axa-shadow-focus-light active:focus:shadow-none"
					type="button">Login</button>
			</div>
		</div>
	</form>
</div>
<%
	}
%>

<script type="text/javascript">
	var _signinEntryURL = "<%=signinEntryURL%>";
	var _otpEntryURL = "<%=otpEntryURL%>";
  var _resendOtpEntryURL = "<%=resendOtpEntryURL%>";
  
</script>

<script
	src="<%=request.getContextPath()%>/js/step1.js?v=<%=numericTimestamptimestampForJSURI%>"
	type="text/javascript"></script>