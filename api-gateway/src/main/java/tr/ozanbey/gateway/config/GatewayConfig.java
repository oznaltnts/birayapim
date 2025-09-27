package tr.ozanbey.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("recipe-service", r -> r
                        .path("/api/recipes/**")
                        .uri("lb://RECIPE-SERVICE"))
                .route("swagger-ui", r -> r
                        .path("/swagger-ui/**", "/v3/api-docs/**")
                        .uri("lb://RECIPE-SERVICE"))
                .build();
    }
}
