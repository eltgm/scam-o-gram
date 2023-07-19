package ru.sultanyarov.authorizationmicroservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.actuate.autoconfigure.security.reactive.ReactiveManagementWebSecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration;
import org.springframework.boot.autoconfigure.web.reactive.HttpHandlerAutoConfiguration;
import org.springframework.boot.autoconfigure.web.reactive.WebFluxAutoConfiguration;
import org.springframework.boot.autoconfigure.web.reactive.error.ErrorWebFluxAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.gateway.config.GatewayAutoConfiguration;
import org.springframework.cloud.gateway.config.GatewayMetricsAutoConfiguration;

@SpringBootTest
@EnableAutoConfiguration(exclude = {
        WebFluxAutoConfiguration.class,
        GatewayAutoConfiguration.class,
        ErrorWebFluxAutoConfiguration.class,
        GatewayMetricsAutoConfiguration.class,
        HttpHandlerAutoConfiguration.class,
        FlywayAutoConfiguration.class,
        ReactiveManagementWebSecurityAutoConfiguration.class
})
class AuthorizationMicroserviceApplicationTests {

    @Test
    void contextLoads() {
    }

}
