package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;

/**
 * Swagger configuration documentation setup
 * 
 * @author P7112764
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select().paths(PathSelectors.any())
				.apis(RequestHandlerSelectors.basePackage("com.example.demo")).build().apiInfo(apiDetails());
	}

	/**
	 * 
	 * @return Returns the api Details
	 */
	private ApiInfo apiDetails() {
		Contact contact = new Contact("Preksha", "http://Preksha", "prekshaps598@gmail.com");
		return new ApiInfoBuilder().title("Product Shopping application Api").build();
	}
}
