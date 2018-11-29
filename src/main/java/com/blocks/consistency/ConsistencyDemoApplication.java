package com.blocks.consistency;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ConsistencyDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsistencyDemoApplication.class, args);
	}
}
