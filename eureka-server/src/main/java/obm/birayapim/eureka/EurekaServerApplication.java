package obm.birayapim.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

// Main application class for Eureka Server
@SpringBootApplication
@EnableEurekaServer // Enable Eureka Server functionality
public class EurekaServerApplication {
    // Entry point to run the application
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class, args);
    }

}
