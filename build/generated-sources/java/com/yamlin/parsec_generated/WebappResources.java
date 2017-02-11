//
// This file is generated by parsec-rdl-gen (development version)
// Please DO NOT edit directly; changes could be overwritten.
//
package com.yamlin.parsec_generated;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.inject.Inject;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import java.io.IOException;
import java.util.Map;
import java.util.Arrays;
import java.util.LinkedHashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.yahoo.parsec.logging.LogUtil;
import org.codehaus.jackson.map.ObjectMapper;


@Path("/webapp/v1")
public class WebappResources {
    private static final Logger LOG = LoggerFactory.getLogger(WebappResources.class);
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @GET
    @Path("/traders")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTraders(
        @QueryParam("q") String q, 
        @QueryParam("offset") @DefaultValue("0") String offset, 
        @QueryParam("count") @DefaultValue("50") Integer count, 
        @QueryParam("orderBy") @DefaultValue("-name") String orderBy
    ) {
        try {
            ResourceContext context = _delegate.newResourceContext(_request, _response);
            context.authenticate();
            TraderList e = _delegate.getTraders(context, q, offset, count, orderBy);
            if (null == e) {
                return Response.noContent().build();
            }
            return Response.status(ResourceException.OK).entity(e).build();
        } catch (ResourceException e) {
            int code = e.getCode();
            switch (code) {
            case ResourceException.BAD_REQUEST:
                throw typedException(code, e, ResourceError.class);
            case ResourceException.FORBIDDEN:
                throw typedException(code, e, ResourceError.class);
            case ResourceException.INTERNAL_SERVER_ERROR:
                throw typedException(code, e, ResourceError.class);
            case ResourceException.UNAUTHORIZED:
                throw typedException(code, e, ResourceError.class);
            default:
                System.err.println("*** Warning: undeclared exception ("+code+") for resource getTraders");
                throw typedException(code, e, ResourceError.class);
            }
        }
    }

    @GET
    @Path("/prod/transactions")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTransactions(
        @QueryParam("q") String q, 
        @QueryParam("sinceId") @DefaultValue("0") String sinceId, 
        @QueryParam("count") @DefaultValue("50") Integer count, 
        @QueryParam("orderBy") @DefaultValue("-value") String orderBy
    ) {
        try {
            ResourceContext context = _delegate.newResourceContext(_request, _response);
            context.authenticate();
            TransactionList e = _delegate.getTransactions(context, q, sinceId, count, orderBy);
            if (null == e) {
                return Response.noContent().build();
            }
            return Response.status(ResourceException.OK).entity(e).build();
        } catch (ResourceException e) {
            int code = e.getCode();
            switch (code) {
            case ResourceException.BAD_REQUEST:
                throw typedException(code, e, ResourceError.class);
            case ResourceException.FORBIDDEN:
                throw typedException(code, e, ResourceError.class);
            case ResourceException.INTERNAL_SERVER_ERROR:
                throw typedException(code, e, ResourceError.class);
            case ResourceException.UNAUTHORIZED:
                throw typedException(code, e, ResourceError.class);
            default:
                System.err.println("*** Warning: undeclared exception ("+code+") for resource getTransactions");
                throw typedException(code, e, ResourceError.class);
            }
        }
    }

    @GET
    @Path("/prod/transactionSummary")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTransactionSummary(
        @QueryParam("q") String q, 
        @QueryParam("op") String op
    ) {
        try {
            ResourceContext context = _delegate.newResourceContext(_request, _response);
            context.authenticate();
            TransactionSummary e = _delegate.getTransactionSummary(context, q, op);
            if (null == e) {
                return Response.noContent().build();
            }
            return Response.status(ResourceException.OK).entity(e).build();
        } catch (ResourceException e) {
            int code = e.getCode();
            switch (code) {
            case ResourceException.BAD_REQUEST:
                throw typedException(code, e, ResourceError.class);
            case ResourceException.FORBIDDEN:
                throw typedException(code, e, ResourceError.class);
            case ResourceException.INTERNAL_SERVER_ERROR:
                throw typedException(code, e, ResourceError.class);
            case ResourceException.UNAUTHORIZED:
                throw typedException(code, e, ResourceError.class);
            default:
                System.err.println("*** Warning: undeclared exception ("+code+") for resource getTransactionSummary");
                throw typedException(code, e, ResourceError.class);
            }
        }
    }


    WebApplicationException typedException(int code, ResourceException e, Class<?> eClass) {
        Object data = e.getData();
        Object entity = eClass.isInstance(data) ? data : null;
        int internalServerErrorCode = ResourceException.INTERNAL_SERVER_ERROR;
        if ((code == internalServerErrorCode && LOG.isErrorEnabled()) || LOG.isDebugEnabled()) {
            String msg = object2StringNoThrow(data);
            String className = this.getClass().getSimpleName();
            // only log two tiers of stacks, there is no problem even if the range overflow
            StackTraceElement[] stacks = Arrays.copyOfRange(Thread.currentThread().getStackTrace(), 1, 3);
            Map<String, String> meta = new LinkedHashMap<>();
            meta.put("trace_tag", className);
            meta.put("http_code", String.valueOf(code));
            meta.put("uri", _request == null ? "" : _request.getRequestURL().toString());
            meta.put("trace_string", Arrays.toString(stacks));
            String logInfo = LogUtil.generateLog(className, msg, meta);
            if (code == internalServerErrorCode) {
                LOG.error(logInfo);
            } else {
                LOG.debug(logInfo);
            }
        }
        if (entity != null)
            return new WebApplicationException(Response.status(code).entity(entity).build());
        else
            return new WebApplicationException(code);
    }

    private static String object2StringNoThrow(Object entity) {
        if (entity == null) {
            return null;
        }

        try {
            return OBJECT_MAPPER.writeValueAsString(entity);
        } catch (IOException e) {
            return null;
        }
    }

    @Inject private WebappHandler _delegate;
    @Context private HttpServletRequest _request;
    @Context private HttpServletResponse _response;

}
