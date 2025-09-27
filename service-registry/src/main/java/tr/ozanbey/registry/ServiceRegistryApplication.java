package tr.ozanbey.registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Service Registry (Eureka) uygulamasının giriş noktası.
 * Bu uygulama diğer microservice'lerin discovery için kayıt olmasını sağlar.
 */
@SpringBootApplication
@EnableEurekaServer
public class ServiceRegistryApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(ServiceRegistryApplication.class, args);
    }
}
