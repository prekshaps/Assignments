package com.examples.demoproduct.Service;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.examples.demoproduct.model.*;
/*
@Service
public class RestService {
	private static final Duration REQUEST_TIMEOUT = Duration.ofSeconds(3);
	private static WebClient localApiClient;
	
	@Autowired
	public RestService(WebClient localApiClient) {
		this.localApiClient = localApiClient;
		}
	public Product getProduct(long id) {
		return localApiClient
				.get()
				.uri("/products"+id)
				.retrieve()
				.bodyToMono(Product.class)
				.block(REQUEST_TIMEOUT);
	}
	
}
*/
public class RestService{
	@Autowired
	private WebClient.Builder webClientBuilder;
	Product product = webClientBuilder.build()
			.get()
			.uri("http://localhost:8087/api/v1/products")
			.retrieve()
			.bodyToMono(Product.class)
			.block();
}
			
