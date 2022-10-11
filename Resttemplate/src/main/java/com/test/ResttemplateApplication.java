package com.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ResttemplateApplication {
	@Bean
     public RestTemplate getRestTemplate()
     {
		return new RestTemplate();
     }
	public static void main(String[] args) {
		SpringApplication.run(ResttemplateApplication.class, args);
	}

}
