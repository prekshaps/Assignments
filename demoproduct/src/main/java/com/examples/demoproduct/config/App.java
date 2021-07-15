package com.examples.demoproduct.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public interface App{
	
@Bean	
public static WebClient.Builder getClientBuilder() {
  return WebClient.builder();
}
}
