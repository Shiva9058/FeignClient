package com.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.entity.User;
import com.test.exception.UserNotFound;
import com.test.service.UserService;

@RestController
public class MyController {
	@Autowired
	UserService userService;

	@GetMapping("/get/{id}")
	public ResponseEntity<Object> getUser(@PathVariable int id) throws UserNotFound {
		return new ResponseEntity<>(userService.getUser1(id), HttpStatus.OK);
	}

	@PostMapping("/add")
	public String addUser(@RequestBody User user1) {
		return userService.addUser1(user1);

	}

	@GetMapping("/getall")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

}
