package com.kirylshreyter.smart_dictionary.webapp.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.kirylshreyter.smart_dictionary.webapp.config.Constants;
import com.kirylshreyter.smart_dictionary.webapp.config.Permissions;
import com.kirylshreyter.smart_dictionary.webapp.utils.ResponseUtils;

public class SignInFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        if (preflightHostRequest((HttpServletRequest) request)) {
            chain.doFilter(request, response);
            return;
        }
        if (authHeaderNotValid((HttpServletRequest) request)) {
            ResponseUtils.getInstance().unauthorizedResponse(response, true);
            return;
        }
        chain.doFilter(request, response);
    }

    public void destroy() {
    }

    private boolean authHeaderNotValid(HttpServletRequest request) {
        String authorization = request.getHeader(Constants.AUTH_HEADER);
        return authorization == null || authorization.isEmpty();
    }

    private boolean preflightHostRequest(HttpServletRequest request) {
        return request.getMethod().equals(Constants.OPTIONS_REQUEST_METHOD) && request.getHeader(Constants.ORIGIN_HEADER).equals(Permissions.CORS_ORIGIN_URI);
    }

}
