package bugsbusters.lucatickets.pagos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

/**
 * Configuración de OpenAPI para la documentación de la API de Pagos.
 */

@Configuration
public class OpenApiConfig {

	/**
	 * Configura y devuelve un objeto OpenAPI que describe la API de Pagos.
	 *
	 * @return Objeto OpenAPI configurado.
	 * @author Adrian
	 */

	@Bean
	public OpenAPI PagoOpenAPI() {
		return new OpenAPI()
				.info(new Info().title("Pago API").description("Documentación del listado de pagos Lucatickets")
						.version("v1.0")
						.contact(new Contact().name("BugsBusters").url("https://BugsBusters.es")
								.email("Bugs@Busters.es"))
						.license(new License().name("LICENSE").url("http://springdoc.org")))
				.externalDocs(
						new ExternalDocumentation().description("Gestion de pagos para la plataforma Lucatickets")
								.url("https://LucaTickets.es"));
	}
}
