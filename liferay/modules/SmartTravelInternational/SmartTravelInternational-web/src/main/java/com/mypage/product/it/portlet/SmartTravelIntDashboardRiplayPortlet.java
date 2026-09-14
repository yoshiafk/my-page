package com.mypage.product.it.portlet;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import com.mypage.admin.product.model.Benefit;
import com.mypage.admin.product.model.BenefitType;
import com.mypage.admin.product.service.BenefitLocalService;
import com.mypage.admin.product.service.BenefitTypeLocalService;
import com.mypage.leads.model.DetailInternationalTravel;
import com.mypage.leads.service.CustomerLocalService;
import com.mypage.leads.service.DetailInternationalTravelLocalService;
import com.mypage.leads.service.LeadsLocalService;
import com.mypage.product.it.constants.SmartTravelIntRiplayPortletKey;
import com.mypage.product.it.helper.MypageHelpers;
import com.mypage.product.it.wrapper.JournalArticleService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		immediate = true,
		property = {
			"com.liferay.portlet.display-category=myPage",
			"com.liferay.portlet.header-portlet-css=/css/main.css",
			"com.liferay.portlet.instanceable=false",
			"javax.portlet.display-name=SmartTravel International Dashboard Riplay",
			"javax.portlet.init-param.template-path=/",
			"javax.portlet.name=" + SmartTravelIntRiplayPortletKey.SMART_TRAVEL_INTERNATIONAL_DASHBOARD_RIPLAY,
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user"
		},
		service = Portlet.class
	)
public class SmartTravelIntDashboardRiplayPortlet extends MVCPortlet{

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		System.out.println("SmartTravelIntDashboard --< RIPLAY Portlet.render() render");
		
		/**
		 * for web content in RIPLAY STEP
		 */
		
		JournalArticleService journalService = new JournalArticleService();
		MypageHelpers helpers = new MypageHelpers();
		helpers.setJournalService(journalService);
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		String riplayVersi = "umum"; //umum/personal

		// Web Content
		String _dataHeader = helpers.getWebContentByFriendlyUrl("value-riplay-"+riplayVersi+"-informasi-produk",
				themeDisplay);
		
		
		String dataItemManfaat = helpers.getWebContentByFriendlyUrl("value-riplay-"+riplayVersi+"-accordion-item-manfaat",
				themeDisplay);
		
		String dataItemResiko = helpers.getWebContentByFriendlyUrl("value-riplay-"+riplayVersi+"-accordion-resiko",
				themeDisplay);
		
		String dataItemBiaya = helpers.getWebContentByFriendlyUrl("value-riplay-"+riplayVersi+"-accordion-item-biaya",
				themeDisplay);
		
		String dataItemKecuali = helpers.getWebContentByFriendlyUrl("value-riplay-"+riplayVersi+"-accordion-item-pengecualian",
				themeDisplay);
		

		String dataItemSyarat = helpers.getWebContentByFriendlyUrl("value-riplay-"+riplayVersi+"-accordion-item-persyaratan",
				themeDisplay);
		
		String dataItemSimulasi = helpers.getWebContentByFriendlyUrl("value-riplay-"+riplayVersi+"-accordion-item-simulasi",
				themeDisplay);
		
		String dataItemInfoTambahan = helpers.getWebContentByFriendlyUrl("value-riplay-"+riplayVersi+"-accordion-item-informasi-tambahan",
				themeDisplay);
		
		String dataItemFiturUtama = helpers.getWebContentByFriendlyUrl("value-riplay-"+riplayVersi+"-accordion-fitur-utama",
				themeDisplay);
		
		String dataItemCatatanPenting = helpers.getWebContentByFriendlyUrl("value-riplay-"+riplayVersi+"-accordion-item-catatan-penting",
				themeDisplay);
		
		String dataItemDisclaimer = helpers.getWebContentByFriendlyUrl("value-riplay-"+riplayVersi+"-accordion-item-disclaimer",
				themeDisplay);
		
		
		// Send web content to JSP
		renderRequest.setAttribute("_data-info", _dataHeader);
		renderRequest.setAttribute("fitur-utama", dataItemFiturUtama);
		renderRequest.setAttribute("item-manfaat", dataItemManfaat);
		renderRequest.setAttribute("item-resiko", dataItemResiko);
		renderRequest.setAttribute("item-biaya", dataItemBiaya);
		renderRequest.setAttribute("item-pengecualian", dataItemKecuali);
		renderRequest.setAttribute("item-persyaratan", dataItemSyarat);
		renderRequest.setAttribute("item-simulasi", dataItemSimulasi);
		renderRequest.setAttribute("item-info-tambahan", dataItemInfoTambahan);
		renderRequest.setAttribute("item-catatan-penting", dataItemCatatanPenting);
		renderRequest.setAttribute("item-disclaimer", dataItemDisclaimer);
		
		renderRequest.setAttribute("riplay-version", riplayVersi);
		
		
		
		/**
		 * end web content
		 */
		
		String leadsId = "94105"; //test ubah nanti
		renderRequest.setAttribute("leadsId", leadsId);
		
		String curr = "IDR";
		renderRequest.setAttribute("currency", curr);
		
		
		DetailInternationalTravel detailLeads =  detailInternationalTravelLocalService.findByLeadsId(Long.valueOf(leadsId));
		System.out.println("detail leads :" + detailLeads.getListBenefitId());
		
		
		String benefitIdsString = detailLeads.getListBenefitId().replaceAll("[\\[\\]\"]", "");

		// Memecah string menjadi array berdasarkan koma sebagai pemisah
		String[] benefitIds = benefitIdsString.split(",");

		// List untuk menampung hasil akhir
		List<Map<String, Object>> jaminanList = new ArrayList<>();

		// Map untuk melacak title yang sudah ada dalam jaminanList
		Map<String, List<String>> jaminanMap = new HashMap<>();

		// Loop melalui benefitIds dan fetch Benefit serta BenefitType
		for (String benefitId : benefitIds) {
		    Benefit benefit = benefitLocalService.fetchBenefit(Long.valueOf(benefitId));
		    if (benefit != null) {
		        BenefitType type = benefitTypeLocalService.fetchBenefitType(benefit.getBenefitTypeId());
		        
		        // Nama title untuk tipe benefit
		        String title = type.getNameId();
		        String item = benefit.getNameId();

		        // Jika title sudah ada di map, tambahkan item ke list yang ada
		        if (jaminanMap.containsKey(title)) {
		            jaminanMap.get(title).add(item);
		        } else {
		            // Jika title belum ada, buat list baru dan masukkan ke map
		            List<String> items = new ArrayList<>();
		            items.add(item);
		            jaminanMap.put(title, items);
		        }
		    }
		}

		// Mengkonversi map ke dalam list format jaminanList yang sesuai
		for (Map.Entry<String, List<String>> entry : jaminanMap.entrySet()) {
		    Map<String, Object> jaminanEntry = new HashMap<>();
		    jaminanEntry.put("title", entry.getKey());
		    jaminanEntry.put("items", entry.getValue());
		    jaminanList.add(jaminanEntry);
		}
		
		String dummyTest = "[\r\n" + 
				"  {\r\n" + 
				"    \"title\": \"Jaminan Ketidaknyamanan Perjalanan\",\r\n" + 
				"    \"items\": [\r\n" + 
				"      \"Keterlambatan dan Pembatalan Perjalanan\",\r\n" + 
				"      \"Penerbangan Tidak Sinambung\",\r\n" + 
				"      \"Bagasi dan Barang Milik Pribadi\",\r\n" + 
				"      \"Keterlambatan Bagasi \",\r\n" + 
				"      \"Pengurangan Perjalanan\",\r\n" + 
				"      \"Kehilangan Uang Mukaatau Pembatalan\",\r\n" + 
				"      \"Dokumen Perjalanan\",\r\n" + 
				"      \"Perlindungan Kartu Kredit\"\r\n" + 
				"    ]\r\n" + 
				"  },\r\n" + 
				"  {\r\n" + 
				"    \"title\": \"Jaminan Kecelakaan dan Medis\",\r\n" + 
				"    \"items\": [\r\n" + 
				"      \"Kompensasi Ganda untuk Kecelakaan Diri dalamPenerbangan\",\r\n" + 
				"      \"Manfaat Perawatan Anak dan Kunjungan Duka\",\r\n" + 
				"      \"Santunan Tunai Rumah Sakit (Luar Negeri)\",\r\n" + 
				"      \"Kehilangan Pendapatan akibat Kecelakaan\"\r\n" + 
				"    ]\r\n" + 
				"  },\r\n" + 
				"  {\r\n" + 
				"    \"title\": \"Jaminan Lainnya\",\r\n" + 
				"    \"items\": [\r\n" + 
				"      \"Pembajakan\",\r\n" + 
				"      \"Terorisme\",\r\n" + 
				"      \"Tanggung Jawab HukumPribadi\",\r\n" + 
				"      \"Telepon Darurat\",\r\n" + 
				"      \"Perlindungan Isi Rumah\",\r\n" + 
				"      \"Kerusakan/ Kehilangan Peralatan Golf Termasuk Biaya Perayaan Hole In One\",\r\n" + 
				"      \"Biaya Resiko Sendiri Kerusakan darikendaraan yang Andasewa\"\r\n" + 
				"    ]\r\n" + 
				"  }\r\n" + 
				"]";
		
		// convert map to json
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		JSONArray jsonArrayDummy = JSONFactoryUtil.createJSONArray();
		try {
			jsonArrayDummy = JSONFactoryUtil.createJSONArray(dummyTest);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		for (Map<String, Object> jaminan : jaminanList) {
		    JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
		    jsonObject.put("title", jaminan.get("title"));

		    // Pastikan items adalah Collection atau array
		    Object items = jaminan.get("items");
		    if (items instanceof Collection<?>) {
		        jsonObject.put("items", JSONFactoryUtil.createJSONArray((Collection<?>) items));
		    } else if (items.getClass().isArray()) {
		        jsonObject.put("items", JSONFactoryUtil.createJSONArray(Arrays.asList((Object[]) items)));
		    }

		    jsonArray.put(jsonObject);
		}

		
		System.out.println("jsonarray>>" + jsonArray.toString());
		System.out.println("jsonArrayDummy>>" + jsonArrayDummy.toString());
		
		
		//renderRequest.setAttribute("benefits", jsonArray.toString());
		renderRequest.setAttribute("benefits", jsonArrayDummy.toString());
		
		
		
		PortletRequestDispatcher dispatcher = getPortletContext().getRequestDispatcher("/META-INF/resources/dashboard/riplay.jsp");
		dispatcher.include(renderRequest, renderResponse);
		
	}
	
	
	@Reference
	private LeadsLocalService leadsLocalService;
	
	@Reference
	private CustomerLocalService customerLocalService;
	
	@Reference
	private DetailInternationalTravelLocalService detailInternationalTravelLocalService;
	
	@Reference
	private BenefitLocalService benefitLocalService;
	
	@Reference
	private BenefitTypeLocalService benefitTypeLocalService;

}
