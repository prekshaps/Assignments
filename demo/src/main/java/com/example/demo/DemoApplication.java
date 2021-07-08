package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		//SpringApplication.run(TestingspringbootrestfulserviceApplication.class, args);

		SpringApplication application = new SpringApplication(DemoApplication.class);
		// ... customize application settings here
		application.run(args);
	}

}