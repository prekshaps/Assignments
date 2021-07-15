package com.example2.demorestapi;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootApplication
@RestController
@RequestMapping("/demorest")
public class DemorestapiApplication {
	
	WebClient webClient;
	
	@PostConstruct
	public void init() {
		webClient=WebClient.builder().baseUrl("http://localhost:8087/api/data").defaultHeader(HttpHeaders.CONTENT_TYPE,MediaType.APPLICATION_JSON_VALUE).build();
	}
	
	@PostMapping("/addproduct")
	public Mono<String>	addProduct(@RequestBody Product product){
		return webClient.post().uri("/product").retrieve().bodyToMono(String.class);
		
	}
	
	@GetMapping("/getProducts")
	public Flux<Product> getAllProducts(){
		return webClient.get().uri("/products").retrieve().bodyToFlux(Product.class);
	}
	
	@GetMapping("/getProducts/{id}")
	public Mono<Product> getProductById(@PathVariable int id){
		return webClient.get().uri("/product/{id}"+id).retrieve().bodyToMono(Product.class);
		}
	@DeleteMapping("/deleteProducts/{id}")
	public Mono<String> deleteProduct(@PathVariable int id,@PathVariable Product product){
		return webClient.delete().uri("/Product/{id}"+id).retrieve().bodyToMono(String.class);
	}
	

	public static void main(String[] args) {
		SpringApplication.run(DemorestapiApplication.class, args);
	}

}
