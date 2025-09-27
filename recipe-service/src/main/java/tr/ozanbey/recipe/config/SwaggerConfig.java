package tr.ozanbey.recipe.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                              .title("Recipe Service API")
                              .version("1.0.0")
                              .description("RESTful API for Recipe Management Microservice")
                              .contact(new Contact()
                                               .name("Ozan Bey")
                                               .email("contact@ozanbey.tr"))
                              .license(new License()
                                               .name("Apache 2.0")
                                               .url("http://www.apache.org/licenses/LICENSE-2.0.html")));
    }
}
