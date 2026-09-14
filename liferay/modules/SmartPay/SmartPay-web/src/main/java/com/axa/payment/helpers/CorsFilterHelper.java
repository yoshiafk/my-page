package com.axa.payment.helpers;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.UriInfo;

public class CorsFilterHelper implements ContainerResponseFilter {

	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
			throws IOException {

		UriInfo uriInfo = requestContext.getUriInfo();
		String path = uriInfo.getPath();
		
		if (path.contains("smartpay")) {
			responseContext.getHeaders().add("Access-Control-Allow-Origin", "*");
			responseContext.getHeaders().add("Access-Control-Allow-Credentials", "true");
			responseContext.getHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
			responseContext.getHeaders().add("Access-Control-Allow-Headers", "Origin, Content-Type, Accept, Authorization");
		}
	}
}