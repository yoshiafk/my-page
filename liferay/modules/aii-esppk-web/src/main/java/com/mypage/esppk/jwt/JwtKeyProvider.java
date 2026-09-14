package com.mypage.esppk.jwt;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.mypage.admin.product.model.MasterGlobalVariable;
import com.mypage.admin.product.service.MasterGlobalVariableLocalService;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.crypto.SecretKey;

@Component(
    immediate = true,
    service = JwtKeyProvider.class
)
public class JwtKeyProvider {
    private static final Log log = LogFactoryUtil.getLog(JwtKeyProvider.class);

    private JwtKeyProviderBase jwtKeyProviderBase;

    @Activate
    protected void activate() {
        log.info("Initializing JwtKeyProvider");

        String secretKey = masterGlobalVariableLocalService.getActiveGlobalVariableByGroup("JWT").stream()
                .filter(v -> v.getName().equalsIgnoreCase("SECRET_KEY") && v.getActive() == 1)
                .map(MasterGlobalVariable::getValue)
                .findFirst()
                .orElse("");

        jwtKeyProviderBase = new JwtKeyProviderBase(secretKey);
        jwtKeyProviderBase.initKey();
    }

    public SecretKey getSigningKey() {
        return jwtKeyProviderBase != null ? jwtKeyProviderBase.getSigningKey() : null;
    }

    @Reference
    private MasterGlobalVariableLocalService masterGlobalVariableLocalService;
}
