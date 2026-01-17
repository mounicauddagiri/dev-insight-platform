package com.example.insights;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DevInsightPlatformApplication {

	public static void main(String[] args) {
		SpringApplication.run(DevInsightPlatformApplication.class, args);
	}

}
