package com.coffeebrew.gatewayserver.filters;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LoggingFilterTest {

    @Autowired
    LoggingFilter target;

    @Test
    void shouldReturnPreAsFilterType() {
        String filterType = target.filterType();

        assertEquals("pre", filterType);
    }

    @Test
    void filterOrder() {
        int filterOrder = target.filterOrder();

        assertEquals(1, filterOrder);
    }

    @Test
    void shouldFilter() {
        boolean shouldFilter = target.shouldFilter();

        assertEquals(true, shouldFilter);
    }
}