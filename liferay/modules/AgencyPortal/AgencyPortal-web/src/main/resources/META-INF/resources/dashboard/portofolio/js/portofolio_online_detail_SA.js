/*alert("portofolio_online_detail_SA.js loaded");
*/

$(document).ready(function() {
    try {
    	
    	document.querySelectorAll('.currency').forEach(function(element) {
    	    element.textContent = `${curr}`;
    	});
    	
    	
        //generate table
    	generateTable(detail);
    	
        
        
    } catch (error) {
        console.error("Gagal parsing JSON:", error);
    }
});



function generateTable(data) {
	
	//alert('render table jaminan');
	
    let tableBody = '';
    
    // Main Coverage
    tableBody += `<tr><td colspan="3" style="border: 1px solid #ddd; padding: 8px; background-color: #ffff00; font-weight: bold; text-align: center;">JAMINAN UTAMA / <i>MAIN COVERAGE</i></td></tr>`;
    data.Benefit.MainBenefit.BenefitList.forEach((benefit, index) => {
        tableBody += `<tr class="main_benefit">
            <td style="border: 1px solid #ddd; padding: 8px; text-align: center;">${index + 1}</td>
            <td style="border: 1px solid #ddd; padding: 8px;"><b>${benefit.Detail.BenefitID}</b><br><i>${benefit.Detail.BenefitEN}</i></td>
            <td style="border: 1px solid #ddd; padding: 8px; font-weight: bold; text-align: left; vertical-align: top;">${new Intl.NumberFormat('id-ID').format(benefit.Value)}</td>
        </tr>`;
    });

    // Extension Coverage
    tableBody += `<tr class="perluasan">
        <td colspan="3" style="border: 1px solid #ddd; padding: 8px; background-color: #ffcc00; font-weight: bold; text-align: center;">PERLUASAN JAMINAN / <i>EXTENSION COVERAGE</i></td>
    </tr>`;
    
    
    
    // Additional Benefit - Allowance
    tableBody += `<tr class="allowance">
        <td colspan="3" style="border: 1px solid #ddd; padding: 8px; background-color: #0099ff; font-weight: bold; text-align: center;">SANTUNAN / <i>ALLOWANCES</i></td>
    </tr>`;
    let allowanceCount = 1;
    let otherCount = 1;
    data.Benefit.AdditionalBenefit.forEach(category => {
        if (category.BenefitType === "Santunan") {
            category.BenefitList.forEach(benefit => {
                tableBody += `<tr class="allowance_benefit">
                    <td style="border: 1px solid #ddd; padding: 8px; text-align: center;">${allowanceCount++}</td>
                    <td style="border: 1px solid #ddd; padding: 8px;"><b>${benefit.Detail.BenefitID}</b><br><i>${benefit.Detail.BenefitEN}</i></td>
                    <td style="border: 1px solid #ddd; padding: 8px; font-weight: bold; text-align: left; vertical-align: top;">${new Intl.NumberFormat('id-ID').format(benefit.Value)}</td>
                </tr>`;
            });
        }
    });
    
    
    // Additional Benefit - Other Cover
    tableBody += `<tr class="other">
        <td colspan="3" style="border: 1px solid #ddd; padding: 8px; background-color: #0099ff; font-weight: bold; text-align: center;">JAMINAN LAINNYA / <i>OTHER COVER</i></td>
    </tr>`;
    data.Benefit.AdditionalBenefit.forEach(category => {
        if (category.BenefitType === "Jaminan Lainnya") {
            category.BenefitList.forEach(benefit => {
                tableBody += `<tr class="other_benefit">
                    <td style="border: 1px solid #ddd; padding: 8px; text-align: center;">${otherCount++}</td>
                    <td style="border: 1px solid #ddd; padding: 8px;"><b>${benefit.Detail.BenefitID}</b><br><i>${benefit.Detail.BenefitEN}</i></td>
                    <td style="border: 1px solid #ddd; padding: 8px; font-weight: bold; text-align: left; vertical-align: top;">${new Intl.NumberFormat('id-ID').format(benefit.Value)}</td>
                </tr>`;
            });
        }
    });
    
    document.getElementById('dynamicTableBody').innerHTML = tableBody;
    
    
    checkAndRemoveBenefitElements(detail.Benefit.AdditionalBenefit);
    
    
}


function checkAndRemoveBenefitElements(additionalBenefits) {
	
//	alert('checkAndRemoveBenefitElements');
	
    const hasSantunan = additionalBenefits.some(benefit => 
        benefit.BenefitType && 
        benefit.BenefitType.toLowerCase() === "santunan" &&
        benefit.BenefitList.length > 0
    );
    const hasJaminanLainnya = additionalBenefits.some(benefit => 
        benefit.BenefitType && 
        benefit.BenefitType.toLowerCase() === "jaminan lainnya" &&
        benefit.BenefitList.length > 0
    );

    if (!hasSantunan) {
        document.querySelectorAll('.allowance').forEach(el => el.remove());
    }

    if (!hasJaminanLainnya) {
        //document.querySelectorAll('.other').forEach(el => el.remove());
        document.querySelectorAll('.other').forEach(el => {
            if (!['BODY', 'HTML', 'HEAD'].includes(el.tagName)) {
                el.style.display = "none";
            }
        });
    }
    
    if (!hasSantunan && !hasJaminanLainnya) {
        document.querySelectorAll('.perluasan').forEach(el => el.remove());
    }
}