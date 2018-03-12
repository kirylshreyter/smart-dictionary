package com.kirylshreyter.smart_dictionary.webapp.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.kirylshreyter.smart_dictionary.webapp.utils.ResponseUtils;

public class SignOutFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String token = httpRequest.getHeader("x-auth-token");
		if (token == null || token.isEmpty()) {
			ResponseUtils.getInstance().unauthorizedResponse(response, true);
			return;
		}
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
	}

}
