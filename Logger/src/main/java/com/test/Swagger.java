package com.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@Configuration
@EnableSwagger2WebMvc
public class Swagger {
	@Bean 
	public Docket swaggerConfig()
	{
		System.out.println("Inside second");
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.any())
				.apis(RequestHandlerSelectors.basePackage("com.test"))
				.build();
	}

}
