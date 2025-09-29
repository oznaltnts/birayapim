package obm.birayapim.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;

// Security configuration for basic authentication (reactive)
@Configuration
@EnableWebFluxSecurity // WebFlux security for reactive gateway
public class SecurityConfig {

    // Configure HTTP security with basic auth
    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        http
                .csrf(ServerHttpSecurity.CsrfSpec::disable) // Disable CSRF for API gateway
                .authorizeExchange(auth -> auth
                        .pathMatchers("/actuator/**").permitAll() // Allow health checks
                        .anyExchange().authenticated() // All other requests need auth
                )
                .httpBasic(Customizer.withDefaults()) // Enable basic authentication
                .formLogin().disable();

        return http.build();
    }

    // Define in-memory user for gateway authentication
    @Bean
    public MapReactiveUserDetailsService userDetailsService() {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        UserDetails admin = User.withUsername("admin")
                .password(encoder.encode("changeit"))
                .roles("ADMIN")
                .build();

        // gateway user (optional)
        UserDetails gateway = User.withUsername("gateway")
                .password(encoder.encode("changeit"))
                .roles("GATEWAY")
                .build();

        return new MapReactiveUserDetailsService(admin, gateway);
    }

    // Password encoder bean
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
