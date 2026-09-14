package com.aii.esppk.admin.portlet;

import com.aii.esppk.admin.constants.AiiEsppkAdminPortletKeys;
import com.aii.esppk.admin.service.SppkUserLocalService;
import com.aii.esppk.admin.service.SppkUserLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.*;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;

import org.jumpmind.symmetric.csv.CsvReader;
import org.osgi.service.component.annotations.Component;

import at.favre.lib.crypto.bcrypt.BCrypt;
import org.osgi.service.component.annotations.Reference;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author GOSITUS
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=SPPK User", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/user/list.jsp",
		"javax.portlet.name=" + AiiEsppkAdminPortletKeys.AIIESPPKADMIN,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class AiiEsppkAdminPortlet extends MVCPortlet {
	public void addSppkUser(ActionRequest actionRequest, ActionResponse actionResponse) {

		String listViewPath = AiiEsppkAdminPortletKeys.LISTVIEW;
		String editViewPath = AiiEsppkAdminPortletKeys.EDITVIEW;

		long sppkUserId = ParamUtil.getLong(actionRequest, "sppkUserId", 0);

		String fullName = ParamUtil.getString(actionRequest, "full_name");
		if(!fullName.isEmpty()) {
			fullName = fullName.toUpperCase();
		}
		
		String loginCode = ParamUtil.getString(actionRequest, "login_code");
		if(!loginCode.isEmpty()) {
			loginCode = loginCode.toLowerCase();
		}
		
		String password = ParamUtil.getString(actionRequest, "password");
		
		if(!password.isEmpty()) {
			password = BCrypt.withDefaults().hashToString(12, password.toCharArray());	
		}
		
		String email = ParamUtil.getString(actionRequest, "email");
		
		String roleCode = "";
		int allAccess = ParamUtil.getInteger(actionRequest, "all_access", 0);
		int accessData = ParamUtil.getInteger(actionRequest, "access_data", 0);
		int accessMonitoring = ParamUtil.getInteger(actionRequest, "access_monitoring", 0);
		int active = ParamUtil.getBoolean(actionRequest, "active", false) ? 1 : 0;
		

		if (sppkUserId > 0) {
			try {
				SppkUserLocalServiceUtil.updateSppkUser(sppkUserId, fullName, loginCode, password, email, roleCode, allAccess, accessData, accessMonitoring, active);
				SessionMessages.add(actionRequest, "dataUpdated");
				actionResponse.getRenderParameters().setValue(AiiEsppkAdminPortletKeys.MVCPATH, listViewPath);
			} catch (Exception e) {
				PortalUtil.copyRequestParameters(actionRequest, actionResponse);
				SessionErrors.add(actionRequest, e.getClass().getName());
				actionResponse.getRenderParameters().setValue(AiiEsppkAdminPortletKeys.MVCPATH, editViewPath);
			}
		} else {
			try {
				SppkUserLocalServiceUtil.addSppkUser(fullName, loginCode, password, email, roleCode, allAccess, accessData, accessMonitoring, active);
				SessionMessages.add(actionRequest, "dataUpdated");
				actionResponse.getRenderParameters().setValue(AiiEsppkAdminPortletKeys.MVCPATH, listViewPath);
			} catch (Exception e) {
				PortalUtil.copyRequestParameters(actionRequest, actionResponse);
				SessionErrors.add(actionRequest, e.getClass().getName());
				actionResponse.getRenderParameters().setValue(AiiEsppkAdminPortletKeys.MVCPATH, editViewPath);
			}
		}
	}

    // Import User
    public void importUser(ActionRequest actionRequest, ActionResponse actionResponse) {
        String liferayHome = PropsUtil.get(PropsKeys.LIFERAY_HOME);
        String filePath = liferayHome + "/liferayTmp/SPPK/importUser.csv";
        List<String> csvHeadLines = Arrays.asList("Nama", "Kode Login", "Kata Sandi", "Email", "Akses Data Debitur", "Akses Data Monitoring", "Active");

        try (FileOutputStream fOut = new FileOutputStream(filePath)) {
            UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
            InputStream is = uploadRequest.getFileAsStream("importFile");
            int i;
            while ((i = is.read()) != -1) {
                fOut.write(i);
            }

            CsvReader csvReader = new CsvReader(new FileReader(filePath));
            csvReader.setDelimiter(';');

            csvReader.readHeaders();
            String[] headers = csvReader.getHeaders();
            if (!new HashSet<>(Arrays.asList(headers)).containsAll(csvHeadLines)) {
                throw new IOException("Cannot parse csv, expecting headers: [" + csvHeadLines.toString() + "]");
            }

            // Error identifier
            int row = 0;
            StringBuilder invalid = new StringBuilder();
            String constRow = "<br>Baris ";

            // Start read each record in file
            while (csvReader.readRecord()) {
                ++row;

                RowValidationResult r = validateRow(csvReader, row, constRow);

                if (!r.valid) {
                    invalid.append(r.error);
                    continue;
                }

                sppkUserLocalService.addSppkUser(r.fullName, r.loginCode, r.password, r.email, "", 0, r.accessDataDebitur, r.accessDataMonitoring, r.active);
            }

            String error = invalid.toString();
            if (!error.isEmpty()) {
                SessionErrors.add(actionRequest, error);
                log.info("Error import user, msg: " + error);
                log.info(error);
            }

            actionResponse.getRenderParameters().setValue(AiiEsppkAdminPortletKeys.MVCPATH, AiiEsppkAdminPortletKeys.LISTVIEW);

        } catch (Exception e) {
            SessionErrors.add(actionRequest, "data-add-failed");
            log.info(e);
            actionResponse.getRenderParameters().setValue(AiiEsppkAdminPortletKeys.MVCPATH, AiiEsppkAdminPortletKeys.LISTVIEW);
        }
    }

    public static class RowValidationResult {
        boolean valid;
        String error;
        String fullName;
        String loginCode;
        String password;
        String email;
        int accessDataDebitur;
        int accessDataMonitoring;
        int active;
    }

    private RowValidationResult validateRow(CsvReader csvReader, int row, String constRow) throws IOException {
        RowValidationResult r = new RowValidationResult();

        String loginCodeVal = csvReader.get("Kode Login");
        if (loginCodeVal == null || loginCodeVal.isEmpty()) {
            r.error = constRow + row + ", Kolom Kode Login.";
            return r;
        }
        r.loginCode = loginCodeVal.toLowerCase();

        // Existing user?
        if (Validator.isNotNull(sppkUserLocalService.getByLoginCode(r.loginCode))) {
            r.error = "<br>User " + r.loginCode + " sudah ada.";
            return r;
        }

        String fullNameVal = csvReader.get("Nama");
        if (fullNameVal == null || fullNameVal.isEmpty()) {
            r.error = constRow + row + ", Kolom Nama.";
            return r;
        }
        r.fullName = fullNameVal.toUpperCase();

        String passwordVal = csvReader.get("Kata Sandi");
        if (passwordVal == null || passwordVal.isEmpty()) {
            r.error = constRow + row + ", Kolom Kata Sandi.";
            return r;
        }
        r.password = BCrypt.withDefaults().hashToString(12, passwordVal.toCharArray());

        String emailVal = csvReader.get("Email");
        if (emailVal == null || emailVal.isEmpty()) {
            r.error = constRow + row + ", Kolom Email.";
            return r;
        }
        r.email = emailVal;

        String accessDebiturVal = csvReader.get("Akses Data Debitur");
        if (accessDebiturVal == null || Integer.parseInt(accessDebiturVal) > 1) {
            r.error = constRow + row + ", Kolom Akses Data Debitur.";
            return r;
        }
        r.accessDataDebitur = Integer.parseInt(accessDebiturVal);

        String accessMonitoringVal = csvReader.get("Akses Data Monitoring");
        if (accessMonitoringVal == null || Integer.parseInt(accessMonitoringVal) > 1) {
            r.error = constRow + row + ", Kolom Akses Data Monitoring.";
            return r;
        }
        r.accessDataMonitoring = Integer.parseInt(accessMonitoringVal);

        String activeVal = csvReader.get("Active");
        if (activeVal == null || Integer.parseInt(activeVal) > 1) {
            r.error = constRow + row + ", Kolom Active.";
            return r;
        }
        r.active = Integer.parseInt(activeVal);

        r.valid = true;
        return r;
    }

    private static final Log log = LogFactoryUtil.getLog(AiiEsppkAdminPortlet.class);

    @Reference
    private SppkUserLocalService sppkUserLocalService;
}