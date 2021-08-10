package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.CreditCardStrategy;
import com.example.demo.model.ExecuteStrategyOne;
import com.example.demo.model.PaypalStrategy;

/**
 * Spring Boot Project Starts with main
 * 
 * @author P7112764
 *
 */
@SpringBootApplication
public class DemoApplication {
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// SpringApplication.run(TestingspringbootrestfulserviceApplication.class,
		// args);

		SpringApplication application = new SpringApplication(DemoApplication.class);
		// ... customize application settings here
		application.run(args);
		example();
	}

	private static void example() {
		ExecuteStrategyOne context = new ExecuteStrategyOne(new CreditCardStrategy());
		System.out.println("amount using credit card " + context.executeStrategy(10));

		ExecuteStrategyOne context1 = new ExecuteStrategyOne(new PaypalStrategy());
		System.out.println("amount using paypal " + context1.executeStrategy(10));
	}

}