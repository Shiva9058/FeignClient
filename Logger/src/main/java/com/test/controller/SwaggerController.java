package com.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SwaggerController {
	@GetMapping("/swagger")
	public String info()
	{
		return "Hello Swagger";
	}

}
