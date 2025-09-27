package tr.ozanbey.config;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Spring Cloud Config Server entry point.
 *
 * - Exposes a configuration server which serves configuration from a backend (native file system or Git).
 * - Keep this class minimal; configuration is in application.yml.
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigServerApplication extends SpringBootServletInitializer {


    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class, args);
    }
}
