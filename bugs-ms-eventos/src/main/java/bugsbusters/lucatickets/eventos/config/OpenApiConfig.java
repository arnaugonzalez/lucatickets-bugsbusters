package bugsbusters.lucatickets.eventos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

/**
 * Configuración de OpenAPI para la documentación de la API de Eventos.
 */

@Configuration
public class OpenApiConfig {

	/**
	 * Configura y devuelve un objeto OpenAPI que describe la API de Eventos.
	 *
	 * @return Objeto OpenAPI configurado.
	 * @author Adrian
	 */

	@Bean
	public OpenAPI EventoOpenAPI() {
		return new OpenAPI()
				.info(new Info().title("Evento API").description("Documentación del listado de eventos Lucatickets")
						.version("v1.0")
						.contact(new Contact().name("BugsBusters").url("https://BugsBusters.es")
								.email("Bugs@Busters.es"))
						.license(new License().name("LICENSE").url("http://springdoc.org")))
				.externalDocs(
						new ExternalDocumentation().description("Gestion de eventos para la plataforma Lucatickets")
								.url("https://LucaTickets.es"));
	}
}
