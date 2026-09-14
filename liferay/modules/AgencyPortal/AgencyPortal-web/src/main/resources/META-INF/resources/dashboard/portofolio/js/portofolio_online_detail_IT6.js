//alert(JSON.stringify(window.detail, null, 2));


$(document).ready(function() {
    try {
    	
    	document.querySelectorAll('.currency').forEach(function(element) {
    	    element.textContent = `${curr}`;
    	});
    	
    	// Jalankan fungsi
    	renderDynamicBenefits(detail.Benefit);
       
    	
    } catch (error) {
        console.error("Gagal parsing JSON:", error);
    }
});

const tbody = document.getElementById("dynamicTableBody");

function renderDynamicBenefits(benefitObj) {
	  const utamaSections = [];
	  const tambahanSections = [];

	  // Pisahkan berdasarkan key
	  Object.keys(benefitObj).forEach(sectionKey => {
	    if (sectionKey.toLowerCase().includes("utama")) {
	      utamaSections.push({ sectionKey, section: benefitObj[sectionKey] });
	    } else {
	      tambahanSections.push({ sectionKey, section: benefitObj[sectionKey] });
	    }
	  });

	  // Render Jaminan Utama terlebih dahulu
	  utamaSections.forEach(({ sectionKey, section }) => {
	    const sectionTitle = section.BenefitType || sectionKey;
	    const benefitList = section.BenefitList || [];

	    tbody.appendChild(createSectionHeader(sectionTitle, "#ffff00"));

	    benefitList.forEach((benefit, idx) => {
	      const detail = benefit.Detail || {};
	      const idHTML = detail.HtmlBenefitID || detail.BenefitID || "-";
	      const enHTML = detail.HtmlBenefitEN || detail.BenefitEN || "-";
	      
	      let amountHtml = detail.Amount || "-";
	      

	      tbody.appendChild(createBenefitRow(idx + 1, idHTML, enHTML, amountHtml));
	    });
	  });

	  // Jika ada tambahan sections, tambahkan header khusus dulu
	  if (tambahanSections.length > 0) {
	    tbody.appendChild(
	    		createSectionHeader('<span style="text-transform: uppercase;">Jaminan Tambahan / <i>Additional Benefit</i></span>', "#ffcc00")
	    );
	  }
	  


	  // Lanjut render Jaminan Tambahan
	  tambahanSections.forEach(({ sectionKey, section }) => {
	    const sectionTitle = section.BenefitType || sectionKey;
	    const benefitList = section.BenefitList || [];

	    tbody.appendChild(createSectionHeader(sectionTitle, "#0099ff"));

	    benefitList.forEach((benefit, idx) => {
	      const detail = benefit.Detail || {};
	      const idHTML = detail.HtmlBenefitID || detail.BenefitID || "-";
	      const enHTML = detail.HtmlBenefitEN || detail.BenefitEN || "-";
	      
	      let amountHtml = detail.Amount || "-";

	      tbody.appendChild(createBenefitRow(idx + 1, idHTML, enHTML, amountHtml));
	    });
	  });
	}


function createSectionHeader(titleHTML, bgColor = "#eee") {
  const tr = document.createElement("tr");
  tr.innerHTML = `<td colspan="3" style="border: 1px solid #ddd; padding: 8px; background-color: ${bgColor}; font-weight: bold; text-align: center;">${titleHTML}</td>`;
  return tr;
}

function createBenefitRow(index, idHTML, enHTML, amount) {
  const tr = document.createElement("tr");
  tr.classList.add("benefit_row");
  tr.innerHTML = `
    <td style="border: 1px solid #ddd; padding: 8px; text-align: center;">${index}</td>
    <td style="border: 1px solid #ddd; padding: 8px;"><b>${idHTML}</b><br>${enHTML}</td>
    <td style="border: 1px solid #ddd; padding: 8px;">${amount}</td>
    
  `;
  return tr;
}


