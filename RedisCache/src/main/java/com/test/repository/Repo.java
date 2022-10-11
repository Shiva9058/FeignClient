package com.test.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.test.entity.Product;
@Repository
public interface Repo extends CrudRepository<Product,Integer>{
	


}
