package tr.ozanbey.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Main application class for the Eureka Server.
 * This service acts as the discovery server for other microservices to register.
 */

/**
 * Main class to bootstrap the Eureka discovery server.
 * Services will register to this application at startup.
 */
@SpringBootApplication
@EnableEurekaServer // Enables this as a Eureka Server
public class EurekaServerApplication {

    /**
     * Entry point to start the Eureka Server.
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class, args);
    }
}
