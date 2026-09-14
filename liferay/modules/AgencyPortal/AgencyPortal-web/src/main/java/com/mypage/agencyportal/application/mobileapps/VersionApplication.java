package com.mypage.agencyportal.application.mobileapps;

import com.google.gson.Gson;
import com.mypage.admin.product.model.MasterGlobalVariable;
import com.mypage.admin.product.service.MasterGlobalVariableLocalServiceUtil;
import com.mypage.agencyportal.dto.mobileapps.VersionDto;
import com.mypage.agencyportal.helpers.CorsFilterHelper;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.*;

@Component(
        property = {
                JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/m",
                JaxrsWhiteboardConstants.JAX_RS_NAME + "=MobileVersion.Rest",
                "auth.verifier.guest.allowed=true",
                "liferay.access.control.disable=true"
        },
        service = Application.class
)
public class VersionApplication extends Application {
    // private static final Log _log = LogFactoryUtil.getLog(BannerApplication.class);

    public Set<Object> getSingletons() {
        return Collections.singleton(this);
    }

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<>();
        classes.add(CorsFilterHelper.class);
        return classes;
    }

    @GET
    @Path("/get-versions")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getVersions() {
        List<MasterGlobalVariable> globalVariable = MasterGlobalVariableLocalServiceUtil.getActiveGlobalVariableByGroup("mapi");

        VersionDto.PlatformVersion android = null;
        VersionDto.PlatformVersion ios = null;

        for (MasterGlobalVariable var : globalVariable) {
            // Skip jika tidak aktif atau value kosong
            if (var.getActive() != 1 || var.getValue() == null || var.getValue().trim().isEmpty()) {
                continue;
            }

            if(var.getName().equalsIgnoreCase("android-version")) {
                android = new VersionDto.PlatformVersion(var.getValue().trim());
            }else if(var.getName().equalsIgnoreCase("ios-version")) {
                ios = new VersionDto.PlatformVersion(var.getValue().trim());
            }
        }

        // Jika tidak ada versi sama sekali
        if (android == null && ios == null) {
            VersionDto errorResponse = new VersionDto(false, "Versi tidak ditemukan", null);
            return Response.ok(new Gson().toJson(errorResponse), MediaType.APPLICATION_JSON).build();
        }

        // build data dan response
        VersionDto.VersionData data = new VersionDto.VersionData(android, ios);
        VersionDto response = new VersionDto(true, "Versi ditemukan", data);

        return Response.ok(new Gson().toJson(response), MediaType.APPLICATION_JSON).build();
    }


}
