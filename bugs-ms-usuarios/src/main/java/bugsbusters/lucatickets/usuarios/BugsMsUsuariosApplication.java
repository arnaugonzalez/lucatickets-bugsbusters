package bugsbusters.lucatickets.usuarios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableDiscoveryClient
@EnableWebMvc
@Validated
public class BugsMsUsuariosApplication {

	public static void main(String[] args) {
		SpringApplication.run(BugsMsUsuariosApplication.class, args);
	}

}
