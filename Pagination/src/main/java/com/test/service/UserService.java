	package com.test.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.test.dao.UserRepository;
import com.test.model.User;

@Service
public class UserService implements DefUser {

	@Autowired
	UserRepository userRepository;
	
	 @Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<User> getData(int pageno, int pageSize) {
		PageRequest paging = PageRequest.of(pageno, pageSize);
		Page<User> page = userRepository.findAll(paging);
		return page.toList();
	}

	public String saveUser(User user) {
		userRepository.save(user);
		return "save sucessefully";
	}

	public User getId(int id) {

		String query = "select * from user where id=?";
		RowMapper<User> rowMapper = new RowMapperImpl();
		System.out.println(id);
		return this.jdbcTemplate.queryForObject(query, rowMapper, id);

	}

}
