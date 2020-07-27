package com.coffeebrew.gatewayserver.services;

import com.coffeebrew.gatewayserver.configs.AuthenticationConfig;
import com.coffeebrew.gatewayserver.models.Endpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AuthenticationService {

    @Autowired
    AuthenticationConfig authenticationConfig;

    public boolean isWhitelisted(String requestURI, String method) {
        List<Endpoint> allWhiteListedEndpoints = authenticationConfig.getAllWhiteListedEndpoints();
        for (int i = 0; i < allWhiteListedEndpoints.size(); i++) {
            if (allWhiteListedEndpoints.get(i).equals(new Endpoint(requestURI, method)))
                return true;
        }
        return false;
    }
}
