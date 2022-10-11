package com.test.service;

import java.util.List;

import com.test.model.User;

public interface DefUser{
	 
	
	public List<User> getData(int pageno,int pageSize);
	public User getId(int id);
	
	}
