package com.revature.nutrition.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.revature")
@EnableJpaRepositories
public class NutritionApplication {

	public static void main(String[] args) {
		SpringApplication.run(NutritionApplication.class, args);
	}

}
