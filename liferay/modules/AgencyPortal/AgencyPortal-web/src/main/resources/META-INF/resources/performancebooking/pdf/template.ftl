<html class="html__agency">
	<head>
        <link href="output.css" rel="stylesheet">
    </head>
	<body class="body__agency">
		<div class="dashboard dashboard__agency dashboard__performance">
			<div class="container container__agency">
				<div class="wrapper__agency wrapper__performance">
					<h1 class="h1__agency">Laporan Pencapaian (Scorecard)</h1>
				</div>
				<div class="performance">
					<div class="performance__name">
						<span class="span-performance-name upper-case">Nama Agen</span>
						<h4 class="h2__agency">${profile.agentName}</h4>
					</div>
					<div class="performance__select performance__select-text">
						<table class="table__filter">
							<thead>
								<tr>
									<td><span class="span-performance-name">Report Bulanan</span></td>
									<td><span class="span-performance-name">Triwulan</span></td>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td><h2 class="h2__agency">${month}</h2></td>
									<td><h2 class="h2__agency">${triwulan}</h2></td>
								</tr>
							</tbody>
						</table>
					</div>
					<div class="performance__desc">
						<table class="table__profile__club">
  							<tr>
								<th class="highlight">Kode Agen</th>
								<td><span class="space-right">:</span>${profile.agentCode}</td>
								
								<th class="highlight">Regional</th>
								<td><span class="space-right">:</span>${profile.agentRegional}</td>
							</tr>
							<tr>
								<th class="highlight">Tanggal Bergabung</th>
								<td><span class="space-right">:</span>${profile.agentJoinDate}</td>
								
								<th class="highlight">Kepala Regional</th>
								<td><span class="space-right">:</span>${profile.agentRegionalHead}</td>
							</tr>
							<tr>
								<th class="highlight">Status Registrasi</th>
								<td><span class="space-right">:</span>${profile.agentRegistStatus}</td>
								
								<th class="highlight">BDE</th>
								<td><span class="space-right">:</span>${profile.agentManager}</td>
							</tr>
							<tr>
								<th class="highlight row-border"></th>
								<td class="row-border"></td>
							
								<th class="highlight row-border">Status Kartu AAUI</th>
								<td class="row-border"><span class="space-right">:</span>${profile.agentAauiStatus}</td>
							</tr>
							<tr>
							    <th class="highlight" style="padding-top: 8px">YTD ${lastYear}</th>
							    <#if lastClubYear??>
									<td style="padding-top: 10px"><span class="space-right">:</span>Rp ${lastClubYear.amount?string["#,##0.00"]}</td>
								<#else>
									<td style="padding-top: 10px"><span class="space-right">:</span>Rp ${0?string["#,##0.00"]}</td>
								</#if>
							    
							    <th class="highlight" style="padding-top: 8px">Klub Terakhir</th>
							    <#if lastClubYear??>
							    	<td style="padding-top: 10px"><span class="space-right">:</span>${lastClubYear.club}</td>
								<#else>
							    	<td style="padding-top: 10px"><span class="space-right">:</span>No Club</td>
								</#if>
							</tr>
							<tr>
							    <th class="highlight">YTD ${currentYear}<sup>*</sup></th>
							    <#if currentClubYear??>
							    	<td><span class="space-right">:</span>Rp ${currentClubYear.amount?string["#,##0.00"]}</td>
								<#else>
									<td><span class="space-right">:</span>Rp ${0?string["#,##0.00"]}</td>
								</#if>
							    
							    <th class="highlight">Klub sekarang</th>
							    <#if currentClubYear??>
							    	<td><span class="space-right">:</span>${currentClubYear.club}</td>
								<#else>
									<td><span class="space-right">:</span>No Club</td>
								</#if>
							</tr>
							<tr>
								<#if currentClubYear??>
							    	<td><i>*) TOTAL YTD PER TANGGAL ${currentClubYear.lastUpdate}</i></td>
							    <#else>
							    	<td><i>*) TOTAL YTD PER TANGGAL ${lastClubYear.lastUpdate}</i></td>
							    </#if>
							</tr>
						</table>
					</div>
					<div class="performance__achievement">
						<div class="performance__achievement--table">
							<h1 class="h1__agency">Pencapaian Mingguan</h1>
							<div class="table-wrapper">
								<table class="table__agency">
									<thead>
										<tr>
											<td>pencapaian</td>
											<td style="text-align: right">GWP ${monthAbbr} ${currentYear}</td>
											<td style="text-align: center">Produk</td>
											<td style="text-align: right">Total</td>
										</tr>
									</thead>
									<tbody class="filter-table-data">
										<tr>
											<#if firstWeek??>
										    	<td>Minggu 1</td>
												<td style="text-align: right">${(firstWeek.amount < 0)?then("(Rp " + firstWeek.amount?string["#,##0.00"]?replace("-", "") + ")", "Rp " + firstWeek.amount?string["#,##0.00"])}</td>
												<td style="text-align: center">${firstWeek.product}</td>
												<td style="text-align: right">${(firstWeek.amount < 0)?then("(Rp " + firstWeek.amount?string["#,##0.00"]?replace("-", "") + ")", "Rp " + firstWeek.amount?string["#,##0.00"])}</td>
											<#else>
												<td>Minggu 1</td>
												<td style="text-align: right">Rp 0.00</td>
												<td style="text-align: center">0</td>
												<td style="text-align: right">Rp 0.00</td>
											</#if>
										</tr>
										<tr class="grey">
											<#if secondWeek??>
										    	<td>Minggu 2</td>
												<td style="text-align: right">${(secondWeek.amount < 0)?then("(Rp " + secondWeek.amount?string["#,##0.00"]?replace("-", "") + ")", "Rp " + secondWeek.amount?string["#,##0.00"])}</td>
												<td style="text-align: center">${secondWeek.product}</td>
												<td style="text-align: right">${(secondWeek.amount < 0)?then("(Rp " + secondWeek.amount?string["#,##0.00"]?replace("-", "") + ")", "Rp " + secondWeek.amount?string["#,##0.00"])}</td>
											<#else>
												<td>Minggu 2</td>
												<td style="text-align: right">Rp 0.00</td>
												<td style="text-align: center">0</td>
												<td style="text-align: right">Rp 0.00</td>
											</#if>
										</tr>
										<tr>
											<#if thirdWeek??>
										    	<td>Minggu 3</td>
												<td style="text-align: right">${(thirdWeek.amount < 0)?then("(Rp " + thirdWeek.amount?string["#,##0.00"]?replace("-", "") + ")", "Rp " + thirdWeek.amount?string["#,##0.00"])}</td>
												<td style="text-align: center">${thirdWeek.product}</td>
												<td style="text-align: right">${(thirdWeek.amount < 0)?then("(Rp " + thirdWeek.amount?string["#,##0.00"]?replace("-", "") + ")", "Rp " + thirdWeek.amount?string["#,##0.00"])}</td>
											<#else>
												<td>Minggu 3</td>
												<td style="text-align: right">Rp 0.00</td>
												<td style="text-align: center">0</td>
												<td style="text-align: right">Rp 0.00</td>
											</#if>
										</tr>
										<tr class="grey">
											<#if fourthWeek??>
										    	<td>Minggu 4</td>
												<td style="text-align: right">${(fourthWeek.amount < 0)?then("(Rp " + fourthWeek.amount?string["#,##0.00"]?replace("-", "") + ")", "Rp " + fourthWeek.amount?string["#,##0.00"])}</td>
												<td style="text-align: center">${fourthWeek.product}</td>
												<td style="text-align: right">${(fourthWeek.amount < 0)?then("(Rp " + fourthWeek.amount?string["#,##0.00"]?replace("-", "") + ")", "Rp " + fourthWeek.amount?string["#,##0.00"])}</td>
											<#else>
												<td>Minggu 4</td>
												<td style="text-align: right">Rp 0.00</td>
												<td style="text-align: center">0</td>
												<td style="text-align: right">Rp 0.00</td>
											</#if>
										</tr>
									</tbody>
									<tfoot>
										<tr class="total">
											<td>Total</td>
											<td style="text-align: right">${(totalWeeklies < 0)?then("(Rp " + totalWeeklies?string["#,##0.00"]?replace("-", "") + ")", "Rp " + totalWeeklies?string["#,##0.00"])}</td>
											<td></td>
											<td style="text-align: right">${(totalWeeklies < 0)?then("(Rp " + totalWeeklies?string["#,##0.00"]?replace("-", "") + ")", "Rp " + totalWeeklies?string["#,##0.00"])}</td>
										</tr>
									</tfoot>
								</table>
							</div>
						</div>
						<div class="performance__achievement--table">
							<h1 class="h1__agency">Pencapaian Triwulan</h1>
							<div class="table-wrapper">
								<table class="table__agency">
									<thead>
										<tr>
											<td>pencapaian</td>
											<td style="text-align: right">GWP ${currentYear}</td>
											<td style="text-align: center">Produk</td>
											<td style="text-align: right">Total</td>
										</tr>
									</thead>
									<tbody class="filter-table-data">
										<tr>
											<#if firstMonth??>
										    	<td>${(firstMonth.period == 1)?then("Januari", (firstMonth.period == 4)?then("April", (firstMonth.period == 7)?then("Juli", "Oktober")))}</td>
												<td style="text-align: right">${(firstMonth.amount < 0)?then("(Rp " + firstMonth.amount?string["#,##0.00"]?replace("-", "") + ")", "Rp " + firstMonth.amount?string["#,##0.00"])}</td>
												<td style="text-align: center">${firstMonth.product}</td>
												<td style="text-align: right">${(firstMonth.amount < 0)?then("(Rp " + firstMonth.amount?string["#,##0.00"]?replace("-", "") + ")", "Rp " + firstMonth.amount?string["#,##0.00"])}</td>
											<#else>
												<td>-</td>
												<td style="text-align: right">-</td>
												<td style="text-align: center">-</td>
												<td style="text-align: right">-</td>
											</#if>
										</tr>
										<tr class="grey">
											<#if secondMonth??>
										    	<td>${(secondMonth.period == 2)?then("Februari", (secondMonth.period == 5)?then("Mei", (secondMonth.period == 8)?then("Agustus", "November")))}</td>
												<td style="text-align: right">${(secondMonth.amount < 0)?then("(Rp " + secondMonth.amount?string["#,##0.00"]?replace("-", "") + ")", "Rp " + secondMonth.amount?string["#,##0.00"])}</td>
												<td style="text-align: center">${secondMonth.product}</td>
												<td style="text-align: right">${(secondMonth.amount < 0)?then("(Rp " + secondMonth.amount?string["#,##0.00"]?replace("-", "") + ")", "Rp " + secondMonth.amount?string["#,##0.00"])}</td>
											<#else>
												<td>-</td>
												<td style="text-align: right">-</td>
												<td style="text-align: center">-</td>
												<td style="text-align: right">-</td>
											</#if>
										</tr>
										<tr>
											<#if thirdMonth??>
										    	<td>${(thirdMonth.period == 3)?then("Maret", (thirdMonth.period == 6)?then("Juni", (thirdMonth.period == 9)?then("September", "Desember")))}</td>
												<td style="text-align: right">${(thirdMonth.amount < 0)?then("(Rp " + thirdMonth.amount?string["#,##0.00"]?replace("-", "") + ")", "Rp " + thirdMonth.amount?string["#,##0.00"])}</td>
												<td style="text-align: center">${thirdMonth.product}</td>
												<td style="text-align: right">${(thirdMonth.amount < 0)?then("(Rp " + thirdMonth.amount?string["#,##0.00"]?replace("-", "") + ")", "Rp " + thirdMonth.amount?string["#,##0.00"])}</td>
											<#else>
												<td>-</td>
												<td style="text-align: right">-</td>
												<td style="text-align: center">-</td>
												<td style="text-align: right">-</td>
											</#if>
										</tr>
									</tbody>
									<tfoot>
										<tr class="total">
											<td>Total</td>
											<td style="text-align: right">${(totalTriwulan < 0)?then("(Rp " + totalTriwulan?string["#,##0.00"]?replace("-", "") + ")", "Rp " + totalTriwulan?string["#,##0.00"])}</td>
											<td></td>
											<td style="text-align: right">${(totalTriwulan < 0)?then("(Rp " + totalTriwulan?string["#,##0.00"]?replace("-", "") + ")", "Rp " + totalTriwulan?string["#,##0.00"])}</td>
										</tr>
									</tfoot>
								</table>
							</div>
						</div>
						<div class="performance__achievement--table">
							<h1 class="h1__agency">Pencapaian Tahunan</h1>
							<div class="table-wrapper">
								<table class="table__agency">
									<thead>
										<tr>
											<td>pencapaian</td>
											<td style="text-align: right">${currentYear}</td>
											<td style="text-align: center">Produk</td>
											<td style="text-align: right">Total</td>
										</tr>
									</thead>
									<tbody class="filter-table-data">
										<tr>
											<#if firstQuarter??>
										    	<td>Triwulan 1</td>
												<td style="text-align: right">${(firstQuarter.amount < 0)?then("(Rp " + firstQuarter.amount?string["#,##0.00"]?replace("-", "") + ")", "Rp " + firstQuarter.amount?string["#,##0.00"])}</td>
												<td style="text-align: center">${firstQuarter.product}</td>
												<td style="text-align: right">${(firstQuarter.amount < 0)?then("(Rp " + firstQuarter.amount?string["#,##0.00"]?replace("-", "") + ")", "Rp " + firstQuarter.amount?string["#,##0.00"])}</td>
											<#else>
												<td>-</td>
												<td style="text-align: right">-</td>
												<td style="text-align: center">-</td>
												<td style="text-align: right">-</td>
											</#if>
										</tr>
										<tr class="grey">
											<#if secondQuarter??>
										    	<td>Triwulan 2</td>
												<td style="text-align: right">${(secondQuarter.amount < 0)?then("(Rp " + secondQuarter.amount?string["#,##0.00"]?replace("-", "") + ")", "Rp " + secondQuarter.amount?string["#,##0.00"])}</td>
												<td style="text-align: center">${secondQuarter.product}</td>
												<td style="text-align: right">${(secondQuarter.amount < 0)?then("(Rp " + secondQuarter.amount?string["#,##0.00"]?replace("-", "") + ")", "Rp " + secondQuarter.amount?string["#,##0.00"])}</td>
											<#else>
												<td>-</td>
												<td style="text-align: right">-</td>
												<td style="text-align: center">-</td>
												<td style="text-align: right">-</td>
											</#if>
										</tr>
										<tr>
											<#if thirdQuarter??>
										    	<td>Triwulan 3</td>
												<td style="text-align: right">${(thirdQuarter.amount < 0)?then("(Rp " + thirdQuarter.amount?string["#,##0.00"]?replace("-", "") + ")", "Rp " + thirdQuarter.amount?string["#,##0.00"])}</td>
												<td style="text-align: center">${thirdQuarter.product}</td>
												<td style="text-align: right">${(thirdQuarter.amount < 0)?then("(Rp " + thirdQuarter.amount?string["#,##0.00"]?replace("-", "") + ")", "Rp " + thirdQuarter.amount?string["#,##0.00"])}</td>
											<#else>
												<td>-</td>
												<td style="text-align: right">-</td>
												<td style="text-align: center">-</td>
												<td style="text-align: right">-</td>
											</#if>
										</tr>
										<tr class="grey">
											<#if fourthQuarter??>
										    	<td>Triwulan 4</td>
												<td style="text-align: right">${(fourthQuarter.amount < 0)?then("(Rp " + fourthQuarter.amount?string["#,##0.00"]?replace("-", "") + ")", "Rp " + fourthQuarter.amount?string["#,##0.00"])}</td>
												<td style="text-align: center">${fourthQuarter.product}</td>
												<td style="text-align: right">${(fourthQuarter.amount < 0)?then("(Rp " + fourthQuarter.amount?string["#,##0.00"]?replace("-", "") + ")", "Rp " + fourthQuarter.amount?string["#,##0.00"])}</td>
											<#else>
												<td>-</td>
												<td style="text-align: right">-</td>
												<td style="text-align: center">-</td>
												<td style="text-align: right">-</td>
											</#if>
										</tr>
									</tbody>
									<tfoot>
										<tr class="total">
											<td>Total</td>
											<td style="text-align: right">${(totalTahunan < 0)?then("(Rp " + totalTahunan?string["#,##0.00"]?replace("-", "") + ")", "Rp " + totalTahunan?string["#,##0.00"])}</td>
											<td></td>
											<td style="text-align: right">${(totalTahunan < 0)?then("(Rp " + totalTahunan?string["#,##0.00"]?replace("-", "") + ")", "Rp " + totalTahunan?string["#,##0.00"])}</td>
										</tr>
									</tfoot>
								</table>
							</div>
						</div>
						<div class="performance__achievement--table">
							<h1 class="h1__agency">LOB</h1>
							<div class="table-wrapper">
								<table class="table__agency">
									<thead>
										<tr>
											<td>pencapaian</td>
											<td style="text-align: right">Triwulan 1</td>
											<td style="text-align: right">Triwulan 2</td>
											<td style="text-align: right">Triwulan 3</td>
											<td style="text-align: right">Triwulan 4</td>
											<td style="text-align: right">Total</td>
										</tr>
									</thead>
									<tbody class="filter-table-data">
										<#list cobs as item>
											<#assign totalPerCob = 0>
											<#assign quarter1 = 0>
									        <#assign quarter2 = 0>
									        <#assign quarter3 = 0>
									        <#assign quarter4 = 0>
									        
									        <#list item.transaction as transaction>
								                <#if transaction.quarter == 1>
								                	<#assign quarter1 = transaction.amount>
										            <#assign totalPerCob = totalPerCob + transaction.amount>
										        </#if>
								                <#if transaction.quarter == 2>
								                    <#assign quarter2 = transaction.amount>
								                    <#assign totalPerCob = totalPerCob + transaction.amount>
								                </#if>
								                <#if transaction.quarter == 3>
								                    <#assign quarter3 = transaction.amount>
								                    <#assign totalPerCob = totalPerCob + transaction.amount>
								                </#if>
								                <#if transaction.quarter == 4>
								                    <#assign quarter4 = transaction.amount>
								                    <#assign totalPerCob = totalPerCob + transaction.amount>
								                </#if>
									        </#list>
											<tr>
												<td>${item.cob}</td>
												<td style="text-align: right">
													<#if quarter1??>
											            <#assign amount = quarter1?string["#,##0.00"]>
											            <#if quarter1 < 0>
											                (Rp ${amount?replace("-", "")})
											            <#else>
											                Rp ${amount}
											            </#if>
											        <#else>
											            Rp 0.00
											        </#if>
								                </td>
								                <td style="text-align: right">
													<#if quarter2??>
											            <#assign amount = quarter2?string["#,##0.00"]>
											            <#if quarter2 < 0>
											                (Rp ${amount?replace("-", "")})
											            <#else>
											                Rp ${amount}
											            </#if>
											        <#else>
											            Rp 0.00
											        </#if>
								                </td>
								                <td style="text-align: right">
													<#if quarter3??>
											            <#assign amount = quarter3?string["#,##0.00"]>
											            <#if quarter3 < 0>
											                (Rp ${amount?replace("-", "")})
											            <#else>
											                Rp ${amount}
											            </#if>
											        <#else>
											            Rp 0.00
											        </#if>
								                </td>
								                <td style="text-align: right">
													<#if quarter4??>
											            <#assign amount = quarter4?string["#,##0.00"]>
											            <#if quarter4 < 0>
											                (Rp ${amount?replace("-", "")})
											            <#else>
											                Rp ${amount}
											            </#if>
											        <#else>
											            Rp 0.00
											        </#if>
								                </td>
								                <td style="text-align: right">${(totalPerCob < 0)?then("(Rp " + totalPerCob?string["#,##0.00"]?replace("-", "") + ")", "Rp " + totalPerCob?string["#,##0.00"])}</td>
											</tr>
								        </#list>
									</tbody>
									<tfoot>
										<tr class="total">
											<td>Total</td>
											<#assign totalPerQuarter = 0>
											<#list [0, 1, 2, 3] as key>
												<td style="text-align: right">
													<#if totalCobPerQuarter[key]??>
											            <#assign amount = totalCobPerQuarter[key].amount?string["#,##0.00"]>
											            <#assign totalPerQuarter = totalPerQuarter + totalCobPerQuarter[key].amount>
											            <#if totalCobPerQuarter[key].amount < 0>
											                (Rp ${amount?replace("-", "")})
											            <#else>
											                Rp ${amount}
											            </#if>
											        <#else>
											            Rp 0.00
											        </#if>
								                </td>
									        </#list>
									        <td style="text-align: right">${(totalPerQuarter < 0)?then("(Rp " + totalPerQuarter?string["#,##0.00"]?replace("-", "") + ")", "Rp " + totalPerQuarter?string["#,##0.00"])}</td>
										</tr>
									</tfoot>
								</table>
							</div>
						</div>
						
						<!-- Tambahan tabel Syarat & Ketentuan -->
						<div class="performance__achievement--table" style="page-break-before: always;">
							<h1 class="h1__agency">Syarat &amp; Ketentuan Perjalanan Eksklusif</h1>
							<div class="table-wrapper">
								<#assign groupHealthGwp = 0>
								<#assign groupHealthMiles = 0>
								<#assign nonGroupHealthGwp = 0>
								<#assign nonGroupHealthMiles = 0>
								<#assign totalGwp = 0>
								<#assign totalMiles = 0>
								<#assign totalPolicy = 0>
								
								<#list reward.terms as item>
									<#if item.name == "GroupHealthGWP">
										<#assign groupHealthGwp = item.amount>
									</#if>
									
									<#if item.name == "AXAMilesGroupHealth">
										<#assign groupHealthMiles = item.amount>
									</#if>
									
									<#if item.name == "NonGroupHealthGWP">
										<#assign nonGroupHealthGwp = item.amount>
									</#if>
									
									<#if item.name == "AXAMilesNonGroupHealth">
										<#assign nonGroupHealthMiles = item.amount>
									</#if>
									
									<#if item.name == "TotalGWP">
										<#assign totalGwp = item.amount>
									</#if>
									
									<#if item.name == "TotalMiles">
										<#assign totalMiles = item.amount>
									</#if>
								
									<#if item.name == "TotalPolicy">
										<#assign totalPolicy = item.amount>
									</#if>
								</#list>
								<table class="table__agency">
									<thead>
										<tr>
											<td>Persyaratan Kontes</td>
											<td style="text-align: right">Total GWP</td>
											<td style="text-align: right">AXA Miles</td>
										</tr>
									</thead>
									<tbody class="filter-table-data">
										<tr>
											<td>Group Health</td>
											<td style="text-align: right">${(groupHealthGwp < 0)?then("(Rp " + groupHealthGwp?string["#,##0.00"]?replace("-", "") + ")", "Rp " + groupHealthGwp?string["#,##0.00"])}</td>
											<td style="text-align: right">${(groupHealthMiles < 0)?then("-", groupHealthMiles?string["#,##0.00"])}</td>
										</tr>
										<tr class="grey">
											<td>Non Group Health</td>
											<td style="text-align: right">${(nonGroupHealthGwp < 0)?then("(Rp " + nonGroupHealthGwp?string["#,##0.00"]?replace("-", "") + ")", "Rp " + nonGroupHealthGwp?string["#,##0.00"])}</td>
											<td style="text-align: right">${(nonGroupHealthMiles < 0)?then("-", nonGroupHealthMiles?string["#,##0.00"])}</td>
										</tr>
										<tr>
											<td>Total</td>
											<td style="text-align: right">${(totalGwp < 0)?then("(Rp " + totalGwp?string["#,##0.00"]?replace("-", "") + ")", "Rp " + totalGwp?string["#,##0.00"])}</td>
											<td style="text-align: right">${(totalMiles < 0)?then("-", totalMiles?string["#,##0.00"])}</td>
										</tr>
										<tr class="grey">
											<td>Polis</td>
											<td colspan="2"style="text-align: center">${totalPolicy}</td>
										</tr>
										<tr>
											<td>Status Reward</td>
											<td colspan="2"style="text-align: center">${reward.status}</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
						
						<!-- Perjalanan Eksklusif -->
						<div class="performance__achievement--table" >
							<h1 class="h1__agency">Perjalanan Eksklusif</h1>
							<div class="table-wrapper" style="margin-bottom: 32px;">
								<table class="table__agency" id="cob-achievement2">
									<thead>
										<tr>
											<td>Reward Tier</td>
											<td>#PAX</td>
										</tr>
									</thead>
									<tbody class="filter-table-data">
										<tr>
											<td>${reward.tier}</td>
											<td>${reward.pax}</td>
										</tr>
									</tbody>
								</table>
							</div>
							
							<div class="table-wrapper" style="margin-bottom: 32px;">
								<table class="table__agency" id="cob-achievement3">
									<thead>
										<tr>
											<td>Peringkat di Club Saat Ini</td>
											<td class="agency-text-center">Office Allowance</td>
											<td class="agency-text-center">Trip Allowance (Min. 5% atas GWP Non Health)</td>
										</tr>
									</thead>
									<tbody class="filter-table-data">
										<tr>
											<td style="text-align: center">${reward.rank}</td>
											<td style="text-align: right">
												<#if (reward.allowance > 0)>
									                Rp ${reward.allowance}
									            <#else>
													-
									            </#if>
											</td>
											<td style="text-align: right">
												<#if (reward.tripAllowance > 0)>
									                Rp ${reward.tripAllowance}
									            <#else>
													-
									            </#if>
											</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
				
				<#--
					<div class="total-polis-per-years">
					    <p>Total Polis Per Tahun : ${totalCob}</p>
					</div>
				-->
				
				<div class="disclaimer" style="page-break-before: always;">
					<h1 class="h1__agency">Pernyataan</h1>
					<div class="disclaimer-wrapper">
						<#if disclaimerContent??>
							<#assign disclaimerContentModified = disclaimerContent?replace('<ol>', '<table class="table">')>
							<#assign disclaimerContentModified = disclaimerContentModified?replace('</ol>', '</table>')>
							
							<#assign disclaimerContentModified = disclaimerContentModified?replace('<li>', '<tr>')>
							<#assign disclaimerContentModified = disclaimerContentModified?replace('</li>', '</tr>')>
							
							<#assign disclaimerContentModified = disclaimerContentModified?replace('<span>', '<td>')>
							<#assign disclaimerContentModified = disclaimerContentModified?replace('</span>', '</td>')>
							
							${disclaimerContentModified}
						<#else>
							<table class="table">
								<tr>
									<th>1)</th>
									<td>Laporan ini dibuat untuk memberikan informasi terbaru mengenai produksi Agen, kontes dan penghargaan tahun ${currentYear}.</td>
								</tr>
								<tr>
									<th>2)</th>
									<td>Laporan ini bukan merupakan hasil akhir dan belum memperhitungkan Performa Polis, Double Polis serta GWP yang masih terhutang tahun ${currentYear}.</td>
								</tr>
								<tr>
									<th>3)</th>
									<td>PT. AXA Insurance Indonesia akan mengirimkan Surat Resmi Pemenang yang ditandatangani pejabat berwenang sebagai informasi hasil akhir.</td>
								</tr>
								<tr>
									<th>4)</th>
									<td>Kontes ini akan diperhitungkan jika Agen dapat mencapai club di tahun sebelumnya (khusus Agen lama), dan untuk Agen baru diharuskan masuk club untuk memenuhi persyaratan kontes ini.</td>
								</tr>
								<tr>
									<th>5)</th>
									<td>Perhitungan kontes ini akan dibayarkan sesuai dengan premi yang sudah dibayarkan sesuai dengan persyaratan kontes yang berlaku di tahun ${currentYear}.</td>
								</tr>
								<tr>
									<th>6)</th>
									<td>Untuk penjelasan lebih lanjut, Bapak/Ibu dapat menghubungi BDE (Business Development Executive) dan Regional Head di kantor perwakilan wilayah masing-masing.</td>
								</tr>
							</table>
						</#if>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>