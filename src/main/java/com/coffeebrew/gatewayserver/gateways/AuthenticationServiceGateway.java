package com.coffeebrew.gatewayserver.gateways;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "authentication-service")
@RibbonClient(name = "authentication-service")
public interface AuthenticationServiceGateway {

    @GetMapping("/auth/token-verify")
    public ResponseEntity<String> verifyToken(@RequestHeader("Authorization") String bearerToken);
}
