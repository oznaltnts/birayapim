package tr.ozanbey.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for defining routes in the API Gateway.
 */
@Configuration
public class GatewayConfig {

    /**
     * Defines the routes for the gateway.
     * Routes requests starting with /api/** to the user-service via load balancer.
     *
     * @param builder RouteLocatorBuilder for building routes.
     * @return RouteLocator with configured routes.
     */
    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("user-service", r -> r.path("/api/**")
                        .uri("lb://user-service")) // lb:// uses Eureka for load balancing
                .build();
    }
}
