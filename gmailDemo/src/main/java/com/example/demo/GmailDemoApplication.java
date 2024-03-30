package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.builders.ApiInfoBuilder;

@SpringBootApplication
public class GmailDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(GmailDemoApplication.class, args);
		System.out.println("Started....");
	}

	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2).select().paths(PathSelectors.ant("/api/gmails/*"))
				.apis(RequestHandlerSelectors.basePackage("com.example.demo")).build().apiInfo(starterClass());
	}

	private ApiInfo starterClass() {
		return new ApiInfoBuilder().title("First Mail").description("Welcome to the Sbv solutions ").version("1.0")
				.build();
	}
}
