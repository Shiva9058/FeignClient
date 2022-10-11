package com.test.restcontroller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Mycontroller {
	@Autowired
	private RestTemplate restTemplate;
	private String urlString="http://localhost:9912/getallbooks";
	@GetMapping("/data")
	public List<Object> getbooks()
	{
	Object[] bookObjects= restTemplate.getForObject(urlString,Object[].class);
	List<Object> list= Arrays.asList(bookObjects);
	return list;
	}

}
