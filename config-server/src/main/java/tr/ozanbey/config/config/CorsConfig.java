package tr.ozanbey.config.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class CorsConfig {
    // Not: Spring Cloud Config Server is servlet-based; if you need CORS for management
    // endpoints prefer a servlet filter. Keep this class commented unless required.
}
