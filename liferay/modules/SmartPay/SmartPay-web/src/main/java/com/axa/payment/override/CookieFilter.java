package com.axa.payment.override;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;

@Component(
    immediate = true,
    property = {
        "osgi.http.whiteboard.filter.pattern=/*",
        "service.ranking:Integer=100"
    }
)
public class CookieFilter implements Filter {

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
	        Cookie[] cookies = httpRequest.getCookies();
	        
	        if (cookies != null) {
	            for (Cookie cookie : cookies) {
	            	if (cookie.getName().equalsIgnoreCase("JSESSIONID") || cookie.getName().contains("TS")) {
	                    cookie.setHttpOnly(true);
	                	cookie.setSecure(true);
	                    cookie.setPath("/");
	                    httpResponse.addCookie(cookie);
	                    break;
	                }
	            }
	        }
        }

        chain.doFilter(request, response);	
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
