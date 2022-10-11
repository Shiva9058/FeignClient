package com.test.controller;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.classic.Logger;
@RestController
public class LogMessage {
	Logger logger=(Logger) LoggerFactory.getLogger(LogMessage.class);
	
	@GetMapping("/get")
	public String message()
	{ 
		logger.info("info message");
		logger.warn("warn message");
		logger.debug("debug message");
		logger.trace("trace message");
		logger.error("error message");
		return "Check console";
	}
	

}
