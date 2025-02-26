package com.wellness.bot.Wellness_bot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.wellness.bot.Wellness_bot.repository") // Ensure repositories are scanned
@EntityScan(basePackages = "model")
public class WellnessBotApplication {

	public static void main(String[] args) {
		SpringApplication.run(WellnessBotApplication.class, args);
	}

}
