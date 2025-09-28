package tr.ozanbey.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * Main application class for the User Service.
 * This service handles user-related CRUD operations and registers with Eureka.
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableJpaAuditing
public class UserServiceApplication extends SpringBootServletInitializer {

    /**
     * Entry point to start the User Service.
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }


    // Configure the application when deployed as WAR
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(UserServiceApplication.class);
    }
}
