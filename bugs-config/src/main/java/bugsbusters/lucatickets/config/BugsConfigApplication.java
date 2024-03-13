package bugsbusters.lucatickets.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class BugsConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(BugsConfigApplication.class, args);
	}

}
