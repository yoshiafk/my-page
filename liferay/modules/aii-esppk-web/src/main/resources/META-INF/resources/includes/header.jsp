<%
	String pageActive = Optional.ofNullable((String) renderRequest.getAttribute("pageActive")).orElse("");
	Boolean accessData = (Boolean) renderRequest.getAttribute("accessData");
	Boolean accessMonitoring = (Boolean) renderRequest.getAttribute("accessMonitoring");
	String fullName = Optional.ofNullable((String) renderRequest.getAttribute("fullName")).orElse("");
%>

<portlet:resourceURL id="/logout" var="signoutURL" />

<nav class="nav-axa-wrapper">
    <div class="container max-w-full sm:max-w-full md:max-w-[1140px] lg:max-w-[1200px] min-[1300px]:max-w-[1200px] min-[1440px]:max-w-[1300px] xl:max-w-[1220px] 2xl:max-w-[1336px] mx-[15px] lg:p-[0px_20px_0px_20px] xl:p-[0px_0px_0px_0px] lg:mx-auto xl:mx-auto">
        <div class="flex w-full flex-wrap items-center justify-between">
            <a class="brand-logo nav-link" href="/aii-sppk/dashboard">
                <img class="h-[50px] mr-4" src="/o/aii-esppk-theme/images/logo_axa_mandiri.png" alt="" loading="lazy">
            </a>
            <div class="flex-grow basis-full items-center hidden xl:flex lg:basis-auto">
                <a class="brand-logo-responsive nav-link" href="/aii-sppk/dashboard">
                    <img class="h-[50px] mr-4" src="/o/aii-esppk-theme/images/logo_axa_mandiri.png" alt="" loading="lazy">
                </a>
                <% if (!pageActive.isEmpty()) { %>
                    <ul class="nav-ul">
                        <li>
                            <a class="<% if (pageActive.equalsIgnoreCase("dashboard")) { %>is-active<% } %> uppercase rounded-[20px] flex nav-link" href="/aii-sppk/dashboard">
                                <svg class="w-[15px] h-6" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 18 19" fill="none">
                                    <path d="M6.67773 18H1.67773V8.85714L9.17773 2L16.6777 8.85714V18H11.0527" stroke-width="2"></path>
                                </svg>
                                <span class="ml-2">Beranda</span>
                            </a>
                        </li>
                        <% if (accessData) { %>
                            <li>
                                <a class="<% if (pageActive.equalsIgnoreCase("debitur")) { %>is-active-link<% } %> uppercase rounded-[20px] block nav-link" href="/aii-sppk/debitur">Data Debitur</a>
                            </li>
                        <% } %>
                        <% if (accessMonitoring) { %>
                            <li>
                                <a class="<% if (pageActive.equalsIgnoreCase("monitoring")) { %>is-active-link<% } %> uppercase rounded-[20px] block nav-link" href="/aii-sppk/monitoring">Data SPPK</a>
                            </li>
                        <% } %>
                    </ul>
                <% } %>
            </div>
            <% if (!pageActive.isEmpty()) { %>
                <div class="nav-right">
                    <div class="relative">
                        <a class="dropdown-toggle dropdown-toggle--user" href="javascript:void(0)" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            <img class="h-[35px]" src="/o/aii-esppk-theme/images/placeholder-profile.png" alt="" loading="lazy">
                            <span><%= fullName %> <i class="fas fa-caret-down fa-fw"></i></span>
                        </a>
                        <ul class="dropdown-menu dropdown-menu-alt dropdown-menu--user">
                            <li>
                                <a class="dropdown-item dropdown-item--logout nav-link--logout" href="/aii-sppk/logout">
                                    <span class="btn btn--dark-blue block text-center"><span class="relative z-10">Keluar <i class="far fa-sign-out ml-2"></i></span></span>
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>

                <!--  Navigation  mobile -->
                <div class="xl:hidden">
                    <div class="flex gap-4 relative">
                        <button class="border-0 bg-transparent w-7 h-7 block" type="button" id="toggle-menu">
                            <div id="hamburger">
                                <span></span>
                                <span></span>
                                <span></span>
                            </div>
                        </button>
                    </div>
                </div>
            <% } %>
        </div>
    </div>
</nav>

<% if (!pageActive.isEmpty()) { %>
    <!--  Navigation container mobile -->
    <div id="navbar">
        <ul class="nav-ul list-style-none overflow-y-scroll trigger-sub">
            <li><a class="p-[18px_25px_18px_25px] block" href="javascript:void(0)"><img class="h-[35px] rounded-full inline-block mr-3" src="/o/aii-esppk-theme/images/placeholder-profile.png" alt="" loading="lazy" /><span class="inline-block uppercase text-blue-300 group-hover:text-white">Welcome, <%= fullName %></span></a></li>
            <li>
                <a class="<% if (pageActive.equalsIgnoreCase("dashboard")) { %>is-active-link<% } %> p-[12px_25px_12px_25px] block nav-link" href="/aii-sppk/dashboard">
                    Beranda
                </a>
            </li>
            <% if (accessData) { %>
                <li>
                    <a class="<% if (pageActive.equalsIgnoreCase("debitur")) { %>is-active-link<% } %> p-[12px_25px_12px_25px] block nav-link" href="/aii-sppk/debitur">Data Debitur</a>
                </li>
            <% } %>
            <% if (accessMonitoring) { %>
                <li>
                    <a class="<% if (pageActive.equalsIgnoreCase("monitoring")) { %>is-active-link<% } %> p-[12px_25px_12px_25px] block nav-link" href="/aii-sppk/monitoring">Data SPPK</a>
                </li>
            <% } %>
            <li class="hidden">
                <a class="dropdown-item dropdown-item--logout" href="#">
                    <span class="btn btn--dark-blue block text-center"><span class="relative z-10">Keluar <i class="far fa-sign-out ml-2"></i></span></span>
                </a>
            </li>
            <div class="btn-logout">
                <a class="dropdown-item dropdown-item--logout nav-link--logout" href="/aii-sppk/logout">
                    <span class="btn btn--dark-blue block text-center"><span class="relative z-10">Keluar <i class="far fa-sign-out ml-2"></i></span></span>
                </a>
            </div>
        </ul>
    </div>
<% } %>

<script type="text/javascript">
	var _signoutURL = "<%= signoutURL %>";
</script>