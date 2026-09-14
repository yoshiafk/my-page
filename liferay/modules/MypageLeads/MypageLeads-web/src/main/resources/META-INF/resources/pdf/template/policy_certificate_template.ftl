<html>
	<head>
		<link href="${baseUrl}/assets/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
		<link href="${baseUrl}/assets/css/style.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<#import "/includes/commons.ftl" as com>
	
		<#-- ---------- Start Header ---------- -->
		<header id="header">
			<div class="row">
				<div class="col-xs-8">
					<img class="header-logo" src="${baseUrl}/assets/images/axa-mandiri.png" alt="AXA MANDIRI" />
				</div>
				<div class="col-xs-4">
					<div class="header_address">
						<strong>PT Mandiri AXA General Insurance</strong><br />
						<strong>Customer Care Center</strong><br />
						AXA Tower lt. GF<br />
						Jl. Prof. Dr. Satrio Kav.18, Kuningan City<br />
						Jakarta 12940, Indonesia<br />
						<table>
							<tr>
								<td width="40">Tel</td>
								<td width="10">:</td>
								<td>1500733 (Senin-Jumat, 08.00-17.00 WIB)</td>
							</tr>
							<tr>
								<td>Email</td>
								<td width="10">:</td>
								<td>customer.general@axa-mandiri.co.id</td>
							</tr>
							<tr>
								<td>Website</td>
								<td width="10">:</td>
								<td>www.axa-mandiri.co.id</td>
							</tr>
						</table>
					</div>
				</div>
			</div>
		</header>
		<#-- ---------- End Header ---------- -->
		
		<#-- ---------- Start Footer ---------- -->
		<section id="footer">
			<div class="row">
				<div class="col-xs-6">
					PT Mandiri AXA General Insurance
				</div>
				<div class="col-xs-6 text-right">
					<span id="pagenumber"></span> of <span id="pagecount"></span>
				</div>
			</div>
		</section>
		<#-- ---------- End Footer ---------- -->
		
		<#-- ---------- Start Content ---------- -->
		<#include content>
		<#-- ---------- End Content ---------- -->
		
		<#-- ---------- Start Additional Pages ---------- -->
		<#if pages?? && pages?size gt 0 >
			<#list pages as page>
				<#include "/pages/"+page+".ftl">
			</#list>
		</#if>
		<#-- ---------- End Additional Pages ---------- -->
	</body>
</html>