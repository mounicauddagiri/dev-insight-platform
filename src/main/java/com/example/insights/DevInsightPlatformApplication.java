package com.example.insights;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class DevInsightPlatformApplication {

	public static void main(String[] args) {
		SpringApplication.run(DevInsightPlatformApplication.class, args);
	}

}
