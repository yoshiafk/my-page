//package com.axa.payment.override;
//
//import com.liferay.portal.kernel.servlet.taglib.DynamicInclude;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.osgi.service.component.annotations.Component;
//
//@Component(
//	immediate = true,
//	service = DynamicInclude.class
//)
//public class TopHeadDynamicInclude implements DynamicInclude {
//
//	@Override
//	public void include(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, String key) throws IOException {
//		PrintWriter writer = httpServletResponse.getWriter();
//
//		writer.println("<script>document.querySelectorAll('script[src*=\"bootstrap.bundle.min.js\"]').forEach(el => el.setAttribute('src', '/combo?browserId=firefox&minifierType=js&languageId=en_US&b=7310&t=1734591609767&/o/frontend-js-jquery-web/jquery/jquery.min.js&/o/frontend-js-jquery-web/jquery/init.js&/o/frontend-js-jquery-web/jquery/ajax.js&/o/frontend-js-jquery-web/jquery/collapsible_search.js&/o/frontend-js-jquery-web/jquery/fm.js&/o/frontend-js-jquery-web/jquery/form.js&/o/frontend-js-jquery-web/jquery/popper.min.js&/o/frontend-js-jquery-web/jquery/side_navigation.js'));</script>");
//        writer.println("<script>document.querySelectorAll('link[data-senna-track=\"temporary\"][hreflang]').forEach(el => el.remove());</script>");
//        writer.println("<script>document.querySelectorAll('meta[property^=\"og:\"]').forEach(el => el.remove());</script>");
//	}
//
//	@Override
//	public void register(DynamicIncludeRegistry dynamicIncludeRegistry) {
//		dynamicIncludeRegistry.register("/html/common/themes/top_head.jsp#post");
//	}
//}
