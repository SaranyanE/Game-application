package com.niit.bej.api.gateway.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@LoadBalancerClient(name = "gaming-service")
public class GameServiceRouteConfig {
    @Bean
    @LoadBalanced
    public RouteLocator locateGamingMicroserviceRoutes(RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder.routes()
                .route(routePredicate -> routePredicate.path("/api/v1/users/**")
                .uri("lb://gaming-service")).build();
    }

}
