//package tr.ozanbey.gateway.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
//import org.springframework.security.config.web.server.ServerHttpSecurity;
//import org.springframework.security.web.server.SecurityWebFilterChain;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//
///**
// * Security configuration for the API Gateway using Spring Security with WebFlux.
// * Enables OAuth2/JWT for protected routes.
// */
//@Configuration
//@EnableWebFluxSecurity // Enables security for reactive web
//@EnableDiscoveryClient
//public class SecurityConfig {
//
//    /**
//     * Configures the security filter chain.
//     * All requests require authentication via OAuth2.
//     *
//     * @param http ServerHttpSecurity for building security config.
//     * @return SecurityWebFilterChain.
//     */
//    @Bean
//    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
//        return http
//                .csrf().disable() // Disable CSRF for simplicity (enable in prod)
//                .authorizeExchange()
//                .pathMatchers("/eureka/**").permitAll() // Allow Eureka access
//                .anyExchange().authenticated() // All other requests need auth
//                .and()
//                .oauth2ResourceServer()
//                .jwt() // Use JWT for authentication
//                .and()
//                .and()
//                .build();
//    }
//}
