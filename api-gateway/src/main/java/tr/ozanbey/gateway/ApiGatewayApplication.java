package tr.ozanbey.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Reactive API Gateway application.
 * Uses Spring Cloud Gateway + WebFlux.
 */

/**
 * Main application class for the API Gateway.
 * This acts as the entry point for all external requests, routing them to appropriate services.
 */
@SpringBootApplication
public class ApiGatewayApplication {

    /**
     * Entry point to start the API Gateway.
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }
}
