package bugsbusters.lucatickets.usuarios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BugsMsUsuariosApplication {

	public static void main(String[] args) {
		SpringApplication.run(BugsMsUsuariosApplication.class, args);
	}

}
