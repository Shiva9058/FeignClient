package com.test.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.test.dao.UserRepo;
import com.test.entity.User;
import com.test.exception.UserNotFound;

@Component
public class UserService {
	private List<User> allUsers2;
	
	@Autowired
	UserRepo userrepo;
	
	User b1;
	public User getUser1(int id) throws UserNotFound
	{
		
	return userrepo.findById(id).orElseThrow(()->new UserNotFound("User Not Found"));
	  
	}
    public String addUser1(User user3)
    {
    	userrepo.save(user3);
    	return "Successfully added";
    }
    public void setAllUsers2(List<User> allUsers) {
		this.allUsers2 = allUsers;
	}

      public List<User> getAllUsers()
    {
    	return userrepo.findAll();
    }
}
