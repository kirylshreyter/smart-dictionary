package com.kirylshreyter.smart_dictionary.webapp.filters;

import com.kirylshreyter.smart_dictionary.services.AuthenticationService;
import com.kirylshreyter.smart_dictionary.services.security.Authentication;
import com.kirylshreyter.smart_dictionary.webapp.config.Constants;
import com.kirylshreyter.smart_dictionary.webapp.config.Permissions;
import com.kirylshreyter.smart_dictionary.webapp.utils.ResponseUtils;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class ApiAuthenticationFilter implements Filter {

	private AuthenticationService authService;

	public void init(FilterConfig filterConfig) throws ServletException {
		authService = WebApplicationContextUtils.getRequiredWebApplicationContext(filterConfig.getServletContext())
				.getBean(AuthenticationService.class);
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
        if (preflightHostRequest((HttpServletRequest) request)) {
            chain.doFilter(request, response);
            return;
        }
		String token = httpRequest.getHeader("x-auth-token");
		if (token == null || token.isEmpty()) {
			ResponseUtils.getInstance().unauthorizedResponse(response, true);
			return;
		}
		Authentication auth = authService.authenticate(token);
		if (!auth.isAuthenticated()) {
			ResponseUtils.getInstance().unauthorizedResponse(response, false);
			return;
		}
		chain.doFilter(request, response);
	}

	public void destroy() {
	}

	private boolean preflightHostRequest(HttpServletRequest request) {
		return request.getMethod().equals(Constants.OPTIONS_REQUEST_METHOD) && request.getHeader(Constants.ORIGIN_HEADER).equals(Permissions.CORS_ORIGIN_URI);
	}
}
