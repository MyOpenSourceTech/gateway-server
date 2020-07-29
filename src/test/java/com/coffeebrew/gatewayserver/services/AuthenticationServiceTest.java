package com.coffeebrew.gatewayserver.services;

import com.coffeebrew.gatewayserver.configs.AuthenticationConfig;
import com.coffeebrew.gatewayserver.models.Endpoint;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class AuthenticationServiceTest {

    @Mock
    AuthenticationConfig authenticationConfig;

    @InjectMocks
    AuthenticationService target;

    @Test
    void shouldReturnTrueForWhitelistedEndpoints() {
        ArrayList<Endpoint> endpoints = new ArrayList<>();
        endpoints.add(new Endpoint("/blog/id;GET"));
        when(authenticationConfig.getAllWhiteListedEndpoints()).thenReturn(endpoints);

        boolean whitelisted = target.isWhitelisted("/blog/id", "GET");

        assertTrue(whitelisted);
    }

    @Test
    void shouldReturnFalseForNonWhitelistedEndpoints() {
        boolean whitelisted = target.isWhitelisted("/kjdvefkj", "GET");

        assertFalse(whitelisted);
    }
}