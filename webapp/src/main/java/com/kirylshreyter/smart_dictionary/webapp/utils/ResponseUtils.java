package com.kirylshreyter.smart_dictionary.webapp.utils;

import java.io.IOException;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.entity.ContentType;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.kirylshreyter.smart_dictionary.webapp.models.security.RestrictedResourceRequested;

public class ResponseUtils {

    private final static String CONTENT_TYPE_HEADER_TITLE = "Content-Type";

    private static final ResponseUtils RESPONSE_UTILS = new ResponseUtils();

    private final JSONObject unauthorizedResponseObject = new JSONObject(
            "{\"error\":\"Username and password are incorrect.\"}");

    private final JSONObject notProvidedAuthInfoResponseObject = new JSONObject(
            "{\"error\":\"You've not provided athorization info.\"}");

    private ResponseUtils() {

    }

    public static ResponseUtils getInstance() {
        return RESPONSE_UTILS;
    }

    public HttpServletResponse unauthorizedResponse(ServletResponse response, boolean authHeader) throws IOException {
        ((HttpServletResponse) response).setHeader(CONTENT_TYPE_HEADER_TITLE,
                ContentType.APPLICATION_JSON.getMimeType());
        ((HttpServletResponse) response).setStatus(HttpStatus.UNAUTHORIZED.value());
        byte[] responseToSend = authHeader ? notProvidedAuthInfoResponseObject.toString().getBytes()
                : unauthorizedResponseObject.toString().getBytes();
        response.getOutputStream().write(responseToSend);
        return (HttpServletResponse) response;
    }

    public ResponseEntity<RestrictedResourceRequested> restrictedResponse() {
        return new ResponseEntity<>(
                new RestrictedResourceRequested("You're not allowed to request this resource."), HttpStatus.FORBIDDEN);
    }
}
