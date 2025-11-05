package com.promo.radar.gatewayserver.routes;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RoutesConfiguration {
    @Bean
    public RouteLocator promoRadarRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("datacollector", r -> r
                        .path("/api/datacollector/**")
                        .uri("http://datacollector:9010")) // Represents Docker service name
                .route("products", r -> r
                        .path("/api/product/**")
                        .uri("http://products:9000")) // Represents Docker service name
                .build();
    }
}
