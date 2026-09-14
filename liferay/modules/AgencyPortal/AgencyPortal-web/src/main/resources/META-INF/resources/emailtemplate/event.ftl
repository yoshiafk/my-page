<html>
	<body>
		<div style="max-width: 800px; margin: 0 auto; font-family: Arial;">
            <div style="padding: 10px 40px 40px;">
                <table style="width: 100%;">
                    <tr>
                        <td style="vertical-align: top;">
                            <div style="width: 50px; height: 70px; overflow: hidden; position: relative;">
                                <div style="float: right; border: 50px solid transparent; border-top: 70px solid #00008f;">
                                </div>
                            </div>
                        </td>
                        <td style="padding-bottom: 50px; text-align: right;">
                            <img alt="logo" height="60" src="${assets.logo}"/>
                        </td>
                    </tr>
                </table>
            </div>
            <div class="body-email" style="padding: 0 30px 0 40px;">
                <h2>[Calendar Event AXA MyPage] ${activity}</h2>

				<p>Hai ${name},</p>
				<p>Anda mendapatkan notifikasi kalendar AXA MyPage <b>${activity}</b> dengan info sebagai berikut:</p>
		
				<table style="border: none;">
					<tr>
						<th style="text-align: left;">Tanggal</th>
						<#if startTime??>
							<td><span style="margin-right: 10px;">:</span><span style="margin-right: 10px;">${startDate} ${startTime} - ${endTime}</span></td>
						<#else>
							<td><span style="margin-right: 10px;">:</span><span style="margin-right: 10px;">${startDate}</span></td>
						</#if>
					</tr>
					<#if location != "">
						<tr>
							<th style="text-align: left;">Lokasi</th>
							<td><span style="margin-right: 10px;">:</span><span style="margin-right: 10px;">${location}</span></td>
						</tr>
					</#if>
					<#if link != "">
						<tr>
							<th style="text-align: left;">Link Meeting</th>
							<td>
								<span style="margin-right: 10px;">:</span><span style="margin-right: 10px;">
									<a href="${link}" style="color: #02048a;">KLIK DI SINI</a>
                                </span>
							</td>
						</tr>
					</#if>
				</table>
		
				<p>Agenda:</p>
				<p>Halo semua agen AII. Diharapkan kepada semua Agen yang mendapatkan email ini bisa join <b>${activity}</b> sesuai informasi yang telah dijelaskan di atas. ditunggu ya</p>
		
				<p><b>Hormat kami,</b></p>
				<p><b>AXA General Insurance</b></p>
            </div>
            <div style="padding: 10px 40px 40px; background-size: cover; background-image: url(${assets.footer}); font-size: 13px;">
                <table style="position: relative; width: 100%;">
                    <tr>
                        <td colspan="3" style="text-align: right;">
                            <img alt="logo" src="${assets.logo}" width="30"/>
                        </td>
                    </tr>
                    <tr width="100%">
                        <td width="40%">
                            <table>
                                <tr width="100%">
                                    <td style="padding-bottom: 0px; color: #02048a; font-size: 12px;" width="100%">
                                        <b>
                                        	${assets.websiteName}
                                        </b>
                                    </td>
                                </tr>
                                <tr>
                                    <td style="color: #02048a; font-size: 12px; padding-bottom: 10px;" width="100%">
                                        <b>
                                            Customer Care Center
                                        </b>
                                    </td>
                                </tr>
                                <tr>
                                    <td style="padding: 0px;">
                                        <table>
                                            <tr>
                                                <td style="display: inline-block; margin-right: 10px; padding: 0px;" width="20">
                                                    <img src="${assets.iconPhone}" width="20"/>
                                                </td>
                                                <td style="display: inline-block; color: #02048a; font-size: 10px;">
                                                    <b>
                                                        <a href="tel:1500733" style="color: #02048a; text-decoration: none;">
                                                            1500 733 (Senin-Jumat, 08.00-17.00 WIB)
                                                        </a>
                                                    </b>
                                                </td>
                                            </tr>
                                        </table>
                                    </td>
                                </tr>
                                <tr>
                                    <td style="padding: 0px;">
                                        <table>
                                            <tr>
                                                <td style="display: inline-block; margin-right: 10px; padding: 0px; vertical-align: middle;" width="20">
                                                    <img src="${assets.iconEmail}" width="20"/>
                                                </td>
                                                <td style="display: inline-block; color: #02048a; font-size: 10px; vertical-align: middle;">
                                                    <b>
                                                        <a href="mailto:&lt;?=\AppHelper\General::settings()-&gt;websiteEmail; ?&gt;" style="color: #02048a; text-decoration: none;">
                                                            ${assets.websiteEmail}
                                                        </a>
                                                    </b>
                                                </td>
                                            </tr>
                                        </table>
                                    </td>
                                </tr>
                            </table>
                        </td>
                        <td style="padding-right: 10px;" width="15%">
                        </td>
                        <td style="padding-left: 10px;" width="45%">
                            <table>
                                <tr>
                                    <td style="padding-bottom: 0px; font-size: 12px; color: #02048a;">
                                        Kunjungi
                                        <b>
                                            <a href="${assets.axaWeb}" style="color: #02048a; text-decoration: none;">
                                                axa.co.id
                                            </a>
                                        </b>
                                        dan
                                        <b>
                                            <a href="https://mypage.axa.co.id/" style="color: #02048a; text-decoration: none;">
                                                mypage.axa.co.id
                                            </a>
                                        </b>
                                    </td>
                                </tr>
                                <tr>
                                    <td style="font-size: 12px; color: #02048a;">
                                        Untuk pembelian produk AXA Insurance secara online.
                                    </td>
                                </tr>
                                <tr>
                                    <table>
                                        <tr>
                                            <td>
                                                <table>
                                                    <tr>
                                                        <td style="display: inline-block; margin-right: 10px;" width="20">
                                                            <img src="${assets.iconInstagram}" width="20"/>
                                                        </td>
                                                        <td style="display: inline-block; color: #02048a;">
                                                            <span style="margin-bottom: 3px; display: block;">
                                                                <b>
                                                                    ${assets.websiteInstagram}
                                                                </b>
                                                            </span>
                                                        </td>
                                                    </tr>
                                                </table>
                                            </td>
                                            <td>
                                                <table>
                                                    <tr>
                                                        <td style="display: inline-block; margin-left: 30px; margin-right: 10px;" width="20">
                                                            <img src="${assets.iconYoutube}" width="20"/>
                                                        </td>
                                                        <td style="display: inline-block; color: #02048a;">
                                                            <span style="margin-bottom: 3px; display: block;">
                                                                <b>
                                                                    ${assets.websiteYoutube}
                                                                </b>
                                                            </span>
                                                        </td>
                                                    </tr>
                                                </table>
                                            </td>
                                        </tr>
                                    </table>
                                </tr>
                            </table>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
	</body>
</html>