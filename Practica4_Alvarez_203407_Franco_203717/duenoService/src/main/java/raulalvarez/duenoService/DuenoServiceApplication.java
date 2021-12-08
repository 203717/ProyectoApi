package raulalvarez.duenoService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class DuenoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DuenoServiceApplication.class, args);
	}

	@Bean
	public RestTemplate getresttemplate(){
		return new RestTemplate();
	}

}
