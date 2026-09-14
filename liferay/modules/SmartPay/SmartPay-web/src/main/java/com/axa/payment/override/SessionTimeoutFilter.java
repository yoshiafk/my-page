package com.axa.payment.override;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.osgi.service.component.annotations.Component;

@Component(
    immediate = true,
    property = {
        "osgi.http.whiteboard.filter.pattern=/*",
        "service.ranking:Integer=100"
    }
)
public class SessionTimeoutFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        if (httpRequest.getServerName().contains("uatmypage") || httpRequest.getServerName().contains("agencyportal") ||
        	httpRequest.getServerName().contains("mypage") || httpRequest.getServerName().contains("mybiz")) {
	        int sessionTimeout = 60;
	        HttpSession session = httpRequest.getSession();
	        session.setMaxInactiveInterval(sessionTimeout * 60);
        }

        chain.doFilter(httpRequest, httpResponse);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
