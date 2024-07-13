package com.challenge.foroalura;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class ForoaluraApplication {

	public static void main(String[] args) {
		SpringApplication.run(ForoaluraApplication.class, args);
	}

}
