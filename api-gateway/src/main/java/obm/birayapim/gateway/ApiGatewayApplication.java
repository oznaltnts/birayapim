package obm.birayapim.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

// Main application class for API Gateway
@SpringBootApplication
@EnableDiscoveryClient // Enable Eureka client for service discovery
public class ApiGatewayApplication {
    // Entry point to run the application
    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }

}
