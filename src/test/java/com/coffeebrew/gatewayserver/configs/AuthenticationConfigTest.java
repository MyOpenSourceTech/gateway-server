package com.coffeebrew.gatewayserver.configs;

import com.coffeebrew.gatewayserver.models.Endpoint;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AuthenticationConfigTest {

    @Autowired
    AuthenticationConfig target;

    @Test
    void shouldGetAllWhiteListedEndpoints() {
        ArrayList<String> endpoints = new ArrayList<>();
        endpoints.add("someurl;GET");

        target.endpoints = endpoints;

        List<Endpoint> allWhiteListedEndpoints = target.getAllWhiteListedEndpoints();

        assertEquals(allWhiteListedEndpoints.get(0).getUrl(), "someurl");
        assertEquals(allWhiteListedEndpoints.get(0).getMethod(), "GET");
    }
}