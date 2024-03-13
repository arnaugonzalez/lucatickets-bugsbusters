package bugsbusters.lucatickets.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class BugsServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BugsServerApplication.class, args);
	}

}
