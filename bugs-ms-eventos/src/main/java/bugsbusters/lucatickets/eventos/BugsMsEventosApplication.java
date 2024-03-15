package bugsbusters.lucatickets.eventos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/**
 * Clase principal de la aplicación de gestión de eventos BugsMsEventosApplication.
 * Esta clase inicia la aplicación Spring Boot para la gestión de eventos y habilita el cliente de descubrimiento de servicios.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class BugsMsEventosApplication {

	
    /**
     * Método principal que inicia la aplicación Spring Boot.
     *
     * @param args Los argumentos de línea de comandos pasados al programa.
     */
	public static void main(String[] args) {
		SpringApplication.run(BugsMsEventosApplication.class, args);
	}

}
