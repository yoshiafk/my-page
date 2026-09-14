<section class="page">
	<div class="row">
		<div class="col-md-12 text-right">
            <p>Jakarta, ${.now?string["dd MMMM yyyy"]}</p>
        </div>
        
        <div class="col-xs-12">
            <table class="table1">
                <tbody>
                    <tr>
                        <td style="padding:0;" width="250">
                            <strong>No</strong>
                        </td>
                        <td style="padding:0;">:</td>
                        <td style="padding:0;">${.now?string["YYMM"]}</td>
                    </tr>
                    <tr>
                        <td style="padding:0;">
                            Perihal/ Re
                        </td>
                        <td style="padding:0;">:</td>
                        <td style="padding:0;"> 
                        	Surat Pernyataan Pertanggungan Asuransi Perjalanan<br />
                            <i>Travel Insurance Coverage Statement Letter</i>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                    </tr>
                    <tr>
                        <td style="padding:0;" width="250">
                            Kepada Yth/ To
                        </td>
                        <td style="padding:0;">:</td>
                        <td style="padding:0;"></td>
                    </tr>
                </tbody>
            </table>
            <br />
        </div>
        <div class="col-xs-12">
            <br />
            Dengan hormat/<i>To whom it may concern,</i>
            <br />
        </div>
	</div>
	
	<div class="row text-justify">
        <div class="col-xs-6">
            <br />
            Dengan ini menyatakan bahwa polis asuransi
            perjalanan di bawah ini:
            <br />
        </div>
        <div class="col-xs-6">
            <br />
            <i>This is to certify that the travel insurance
                policy with the reference below:</i>
            <br />
        </div>
    </div>
    
    <div class="row text-justify">
        <div class="col-xs-6">
            <br />
            Nomor Sertifikat Polis : ${leads.referenceNumber}<br />
            Nama Pemegang Polis : ${leads.name}<br />
            Nama Tertanggung : ${customers[0].name}
            <br />
        </div>
        <div class="col-xs-6">
            <br />
            <i>
                Policy Certificate Number : ${leads.referenceNumber}<br />
                Name of the Policy Holder : ${leads.name}<br />
                Name of the Insured : ${customers[0].name}
            </i>
            <br />
        </div>
    </div>
    
    <div class="row text-justify">
        <div class="col-xs-6">
            <br />
            mencakup manfaat Medis dan Repatriasi termasuk dalam hal terjadi klaim terkait infeksi pandemi (termasuk Covid-19), manfaat tersebut tercantum dalam polis.
            <br />
        </div>
        <div class="col-xs-6">
            <br />
            <i>
                is covering Medical and Repatriation benefits including in the case of the occurrence of claims related to pandemic infection (including Covid-19), the benefits be stated in the policy.
            </i>
            <br />
        </div>
    </div>
    <div class="row text-justify">
        <div class="col-xs-6">
            <br />
            Mohon diperhatikan bahwa sesuai dengan kebijakan peraturan pemerintah Indonesia, jika tertanggung bepergian ke negara lain yang bertentangan dengan anjuran perjalanan pemerintah, manfaat medis dan repatriasi jika terjadi pandemi akan ditanggung dan akan dibatasi sesuai dengan manfaat yang tercantum dalam sertifikat polis.
            <br />
        </div>
        <div class="col-xs-6">
            <br />
            <i>
                Please note that in accordance to the Indonesian government policy, if the insured is traveling in countries against the government travel advice, the medical and repatriation benefits in case of pandemic will be covered and will be limited as per the benefits stated in the policy and schedule
            </i>
            <br />
        </div>
    </div>
    <div class="row text-justify">
        <div class="col-xs-6">
            <br />
            Surat ini dibuat untuk keperluan persyaratan asuransi perjalanan, yang hanya dapat diberikan kepada pihak-pihak terkait dalam jangka waktu perjalanan yang tercantum dalam polis.
            <br />
        </div>
        <div class="col-xs-6">
            <br />
            <i>
                This letter is made for the purpose of travel insurance requirement, which may only be provided to the relevant parties within the travel period stated in the policy.
            </i>
            <br />
        </div>
    </div>
    
    <div class="row">
        <div class="col-xs-12">
            <br />
            <br />
            Hormat Kami/<i>Regards,</i><br />
            <#include "/includes/signature.ftl">
            <br />
        </div>
        <div class="col-xs-12">
            <br />
            Untuk rincian lengkap tentang ketentuan asuransi, silakan mengacu kepada ketentuan Polis
            Asuransi.<br />
        </div>
        <div class="col-xs-12">
            <i>For the full details on the insurance conditions, please refer to the Insurance Policy terms.</i>
        </div>
    </div>
</section>