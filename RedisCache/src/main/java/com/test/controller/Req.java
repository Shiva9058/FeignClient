package com.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.entity.Product;
import com.test.service.UserService;

@RestController
public class Req {
	@Autowired
	UserService userService;
	@GetMapping("/get/{id}")
	ResponseEntity<Product> get1(@PathVariable int id)
	{
		return userService.find(id);
	}
	@GetMapping("/get/all")
	ResponseEntity<List<Product>> get2()
	{
		return userService.findall();
	}
	
	@DeleteMapping("/del/{id}")
	ResponseEntity<String> remove(@PathVariable int id)
	{
		return userService.delete(id);
	}
	
	@PostMapping("/add")
	ResponseEntity<String> store(@RequestBody Product p)
	{
		return userService.add(p);
	}
    @PutMapping("/update/{id}/{name}")
    ResponseEntity<Product> update(@PathVariable int id,@PathVariable String name)
    {
    	return userService.update(id, name);
    }
}
//get keys*
//Hgetall Product("RedisHash annotation value")