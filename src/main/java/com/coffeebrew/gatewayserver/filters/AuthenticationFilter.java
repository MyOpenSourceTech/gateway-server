package com.coffeebrew.gatewayserver.filters;

import com.coffeebrew.gatewayserver.gateways.AuthenticationServiceGateway;
import com.coffeebrew.gatewayserver.services.AuthenticationService;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationFilter extends ZuulFilter {

    @Autowired
    AuthenticationService authenticationService;

    @Autowired
    AuthenticationServiceGateway authenticationServiceGateway;

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 2;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext context = RequestContext.getCurrentContext();
        String requestURI = context.getRequest().getRequestURI();
        String method = context.getRequest().getMethod();
        boolean isWhitelisted = authenticationService.isWhitelisted(requestURI, method);
        if (isWhitelisted) {
            return false;
        }
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        String authorization = context.getRequest().getHeader("Authorization");
        ResponseEntity<String> responseEntity = authenticationServiceGateway.verifyToken(authorization);
        if (!responseEntity.getStatusCode().equals(HttpStatus.OK)) {
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(403);
            context.setResponseBody("{\"error\":\"Authentication failed!\"}");
            context.setRouteHost(null);
        }
        return null;
    }
}
