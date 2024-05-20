package org.example.fan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CeilingFanCodeTestApiSolutionApplication {

	public static void main(String[] args) {
		SpringApplication.run(CeilingFanCodeTestApiSolutionApplication.class, args);
	}

}
