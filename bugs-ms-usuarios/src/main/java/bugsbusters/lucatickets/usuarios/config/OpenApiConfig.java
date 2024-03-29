package bugsbusters.lucatickets.usuarios.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {
	@Bean
	public OpenAPI UsuarioOpenAPI() {
		return new OpenAPI()
				.info(new Info().title("Usuario API").description("Documentación del listado de usuarios Lucatickets")
						.version("v1.0")
						.contact(new Contact().name("BugsBusters").url("https://BugsBusters.es")
								.email("Bugs@Busters.es"))
						.license(new License().name("LICENSE").url("http://springdoc.org")))
				.externalDocs(
						new ExternalDocumentation().description("Gestion de usuarios para la plataforma Lucatickets")
								.url("https://LucaTickets.es"));
	}
}
