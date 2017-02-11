package com.yamlin;

import com.yamlin.parsec_generated.ResourceContext;
import com.yamlin.parsec_generated.ResourceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ResourceContext default implementation.
 */
public class DefaultResourceContext implements ResourceContext {
    /**
     * Request.
     */
    private HttpServletRequest request;

    /**
     * Response.
     */
    private HttpServletResponse response;


    private final String apiKey = "";

    /**
     * Constructor.
     * @param request Request
     * @param response Response
     */
    public DefaultResourceContext(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    /**
     * Get request.
     * @return Request
     */
    @Override
    public HttpServletRequest request() {
        return request;
    }

    /**
     * Get response.
     * @return Response
     */
    @Override
    public HttpServletResponse response() {
        return response;
    }

    /**
     * Authenticate.
     */
    @Override
    public void authenticate() {
//        String key = request.getHeader("x-api-key");
        // do something
//        if (!apiKey.equals(key)) {
//            throw new ResourceException(ResourceException.FORBIDDEN);
//        }
    }

    /**
     * Authorize.
     * @param action Action
     * @param resource Resource
     * @param trustedDomain Trusted domain
     */
    @Override
    public void authorize(String action, String resource, String trustedDomain) {
        // Unused
    }
}
