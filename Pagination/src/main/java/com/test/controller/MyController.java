package com.test.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.model.User;
import com.test.service.DefUser;
import com.test.service.UserService;

@RestController
public class MyController {
	@Autowired
    UserService userService;
	
	DefUser defUser=new UserService();
	
	@GetMapping("/get/{pageno}/{pagesize}")
	public List<User> getvalue(@PathVariable int pageno,@PathVariable int pagesize)
	{
	       return  userService.getData(pageno, pagesize);  
	}
	@PostMapping("/save")
	public ResponseEntity<String> saveUser(@RequestBody User user){
		return ResponseEntity.ok(userService.saveUser(user));
	}
	
	@GetMapping("/gets/{id}")
		public User getRecord(@PathVariable int id)
		{
			System.out.println("HEllo");
			return userService.getId(id);
		}
	}
