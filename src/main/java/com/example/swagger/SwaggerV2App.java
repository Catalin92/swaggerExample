package com.example.swagger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2 // or use environment property
public class SwaggerV2App {

	public static void main(String[] args) {
		SpringApplication.run(SwaggerV2App.class, args);

		//http://localhost:8080/swagger/v2/api-docs
		//http://localhost:8080/swagger/swagger-ui.html
	}

}
