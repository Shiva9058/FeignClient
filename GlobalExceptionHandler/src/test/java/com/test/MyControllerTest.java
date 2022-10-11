package com.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.test.controller.MyController;
import com.test.entity.User;
import com.test.service.UserService;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MyControllerTest {

//	@Autowired
//	UserService userService ;

	@Mock
	private UserService service;

	@InjectMocks
	private MyController controller;

	@Test
	void getResult() throws Exception {
		User user1 = new User(15, "siwan", "Amitjk", "84801");
		User user2 = new User(16, "siwan", "asaddhh", "84801");
		 User user3 = new User(13, "Aru", "hyderabad", "201204");
		List<User> list = Arrays.asList(user1, user2,user3);
		service.setAllUsers2(list);
		Mockito.when(service.getAllUsers()).thenReturn(list);
		// Actual
		List<User> actualList = controller.getAllUsers();

		// Then
		assertThat(actualList).containsExactly(user1, user2,user3);

	}
}
