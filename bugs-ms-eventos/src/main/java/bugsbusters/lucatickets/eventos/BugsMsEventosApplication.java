package bugsbusters.lucatickets.eventos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BugsMsEventosApplication {

	public static void main(String[] args) {
		SpringApplication.run(BugsMsEventosApplication.class, args);
	}

}
