package com.coffeebrew.gatewayserver.configs;

import com.coffeebrew.gatewayserver.models.Endpoint;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@PropertySource({"classpath:authentication.properties"})
public class AuthenticationConfig {
    @Value("#{'${whiteListed.apis}'.split(',')}")
    protected List<String> endpoints;

    public List<Endpoint> getAllWhiteListedEndpoints() {
        List<Endpoint> whitelistedEndpoints = new ArrayList<>();
        for (int i = 0; i < endpoints.size(); i++) {
            whitelistedEndpoints.add(new Endpoint(endpoints.get(i)));
        }
        return whitelistedEndpoints;
    }
}
