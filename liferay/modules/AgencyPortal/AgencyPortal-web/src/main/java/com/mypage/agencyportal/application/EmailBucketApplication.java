package com.mypage.agencyportal.application;

import com.itextpdf.io.source.ByteArrayOutputStream;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.util.FileUtil;
import com.mypage.admin.product.model.MasterGlobalVariable;
import com.mypage.admin.product.service.MasterGlobalVariableLocalServiceUtil;
import com.mypage.agencyportal.helpers.ActionHelpers;
import com.mypage.agencyportal.helpers.EmailHelper;
import com.mypage.agencyportal.model.AgentEmailBucket;
import com.mypage.agencyportal.service.AgentEmailBucketLocalServiceUtil;

import java.io.OutputStreamWriter;
import java.util.Base64;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;

@Component(
	property = {
		JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/email",
		JaxrsWhiteboardConstants.JAX_RS_NAME + "=EmailBucket.Rest",
		"auth.verifier.guest.allowed=true",
		"liferay.access.control.disable=true"
	},
	service = Application.class
)
public class EmailBucketApplication extends Application {
	public Set<Object> getSingletons() {
		return Collections.<Object>singleton(this);
	}
	
	@POST
	@Path("/send")
	@Produces("application/json")
	public String send(@Context HttpServletRequest httpServletRequest) throws Exception {
		ActionHelpers helpers = new ActionHelpers();
		EmailHelper emailHelper = new EmailHelper();
		JSONObject _output = JSONFactoryUtil.createJSONObject();
		JSONObject _assets = JSONFactoryUtil.createJSONObject();
		
		int size = Integer.parseInt(helpers.getConfig("com.mypage.agent.config.listEmail"));
		
		List<AgentEmailBucket> emails = AgentEmailBucketLocalServiceUtil.findByFilter(size);
		
		if (emails.size() > 0) {
			List<MasterGlobalVariable> variables = MasterGlobalVariableLocalServiceUtil.getActiveGlobalVariableByGroup("Email Assets");
			for (MasterGlobalVariable variable : variables) {
				String key = variable.getName().equalsIgnoreCase("main logo") == true ? "logo" :
							 variable.getName().equalsIgnoreCase("footer background") == true ? "footer" :
							 variable.getName().equalsIgnoreCase("website name") == true ? "websiteName" :
							 variable.getName().equalsIgnoreCase("icon phone") == true ? "iconPhone" :
							 variable.getName().equalsIgnoreCase("icon email") == true ? "iconEmail" :
							 variable.getName().equalsIgnoreCase("website email") == true ? "websiteEmail" :
							 variable.getName().equalsIgnoreCase("axa web") == true ? "axaWeb" :
							 variable.getName().equalsIgnoreCase("icon instagram") == true ? "iconInstagram" :
							 variable.getName().equalsIgnoreCase("icon youtube") == true ? "iconYoutube" :
							 variable.getName().equalsIgnoreCase("website instagram") == true ? "websiteInstagram" :
							 variable.getName().equalsIgnoreCase("website youtube") == true ? "websiteYoutube" : "";
				String value = variable.getValue();
				
				if (variable.getImageFileEntryId() > 0) {
					FileEntry file = DLAppLocalServiceUtil.getFileEntry(variable.getImageFileEntryId());
		        	byte[] fileBytes = FileUtil.getBytes(file.getContentStream());
					value = "data:image/png;base64,".concat(Base64.getEncoder().encodeToString(fileBytes));
				}
				
				_assets.put(key, value);
			}
			
			for (AgentEmailBucket email : emails) {
				ByteArrayOutputStream htmlStream = new ByteArrayOutputStream();
				Configuration configuration = new Configuration(Configuration.VERSION_2_3_29);
				configuration.setTemplateLoader(new ClassTemplateLoader(getClass(), "/"));
		        
		        Template template = configuration.getTemplate(email.getTemplate());
		        
		        JSONObject data = JSONFactoryUtil.createJSONObject(email.getParams());
		        data.put("activity", email.getActivity());
		        data.put("assets", _assets);
		        
		        template.process(data, new OutputStreamWriter(htmlStream));
	
		        String htmlContent = htmlStream.toString();
				
				boolean success = emailHelper.sendEmail(email.getRecipient(), email.getSubject(), htmlContent);
				
				if (success == true) {
					ServiceContext serviceContext = ServiceContextFactory.getInstance(AgentEmailBucket.class.getName(),
							httpServletRequest);
					AgentEmailBucketLocalServiceUtil.setStatus(email.getAgentEmailBucketId(), "Success", serviceContext);
				} else {
					ServiceContext serviceContext = ServiceContextFactory.getInstance(AgentEmailBucket.class.getName(),
							httpServletRequest);
					AgentEmailBucketLocalServiceUtil.setStatus(email.getAgentEmailBucketId(), "Failed", serviceContext);
				}
			}
		}
		
		_output.put("status", true);
		_output.put("message", StringPool.BLANK);

		return _output.toString();
	}
}
