package sn.isi.master2.config;



import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

//    http://localhost:8081/swagger-ui/index.html

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Master2 API")
                        .description("API de gestion des membres et des livres")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Fatoumata Diouf")
                                .email("fatoumatadioufkm@groupeisi.sn"))
                );
    }

}
