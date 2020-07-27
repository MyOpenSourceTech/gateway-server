package com.coffeebrew.gatewayserver.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AuthenticationServiceTest {

    @Autowired
    AuthenticationService target;

    @Test
    void shouldReturnTrueForWhitelistedEndpoints() {
        boolean whitelisted = target.isWhitelisted("/blog/id", "GET");

        assertTrue(whitelisted);
    }

    @Test
    void shouldReturnFalseForNonWhitelistedEndpoints() {
        boolean whitelisted = target.isWhitelisted("/kjdvefkj", "GET");

        assertFalse(whitelisted);
    }
}