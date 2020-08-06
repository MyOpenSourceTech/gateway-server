package com.coffeebrew.gatewayserver.filters;

import org.apache.catalina.filters.CorsFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class CustomerFilter {
    @Bean
    public FilterRegistrationBean corsFilterRegistration() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new CorsFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("cors.allowed.methods", "GET,POST,HEAD,OPTIONS,PUT");
        filterRegistrationBean.addInitParameter("cors.allowed.headers", "Content-Type,X-Requested-With,accept,Origin,Access-Control-Request-Method,Access-Control-Request-Headers,Access-Control-Allow-Headers,Access-Control-Allow-Methods,Access-Control-Allow-Origin,Authorization,Accept");
        filterRegistrationBean.addInitParameter("cors.exposed.headers", "Access-Control-Allow-Origin,Access-Control-Allow-Credentials");
        filterRegistrationBean.addInitParameter("cors.support.credentials", "false");
        filterRegistrationBean.addInitParameter("cors.preflight.maxage", "1800");
        filterRegistrationBean.addInitParameter("cors.allowed.origins", "*");
        filterRegistrationBean.setName("CorsFilter");
        filterRegistrationBean.setOrder(1);
        return filterRegistrationBean;
    }
}
