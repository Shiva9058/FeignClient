package com.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.test.entity.Product;

@Service
public class UserService {
	public static final String Hash_key = "Product";
	@SuppressWarnings("rawtypes")
	@Autowired
	private RedisTemplate redisTemplate;

	@SuppressWarnings("unchecked")
	public ResponseEntity<String> add(Product pro) {
		redisTemplate.opsForHash().put(Hash_key, pro.getId(), pro);
		return ResponseEntity.ok("Save successfully");
	}

	public ResponseEntity<Product> find(int id) {
		@SuppressWarnings("unchecked")
		Product product = (Product) redisTemplate.opsForHash().get(Hash_key, id);
		return ResponseEntity.ok(product);
	}
	@SuppressWarnings("unchecked")
	public ResponseEntity<List<Product>> findall() {
		return ResponseEntity.ok(redisTemplate.opsForHash().values(Hash_key));
		
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<Product> update(int id, String name) {
		Product product =(Product)redisTemplate.opsForHash().get(Hash_key, id);
		try {
			product.setName(name);
			redisTemplate.opsForHash().put(Hash_key, product.getId(), product);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return ResponseEntity.ok(product);
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<String> delete(int id) {
       redisTemplate.opsForHash().delete(Hash_key, id);
		return ResponseEntity.ok("Successfully deleted");
	}
}
