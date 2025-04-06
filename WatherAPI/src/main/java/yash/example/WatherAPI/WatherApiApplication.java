package yash.example.WatherAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableScheduling
public class WatherApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(WatherApiApplication.class, args);
	}


	@Bean
	public RestTemplate restTemplate(){

		return new RestTemplate();
	}
}
