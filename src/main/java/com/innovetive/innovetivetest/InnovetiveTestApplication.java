package com.innovetive.innovetivetest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class InnovetiveTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(InnovetiveTestApplication.class, args);
	}
}
