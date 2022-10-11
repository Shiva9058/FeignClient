package com.test;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.test.dao.UserRepo;
import com.test.entity.User;
import com.test.service.UserService;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(MockitoJUnitRunner.class)
public class MyServiceTest {
	@Mock
	UserRepo userRepo;
	@InjectMocks
	UserService userService;
@Test
void TestResult()throws Exception
{
	User user1 = new User(15,"Amitkjhg","siwan", "84801");
	User user2 = new User(16,"asadd","siwan", "84801");
	Mockito.when(userRepo.findById(15)).thenReturn(Optional.of(user1));
	User actuaList=userService.getUser1(15);
	// List<User> actualList= userService.getAllUsers();
	System.out.println(actuaList.toString());
	System.out.println(Arrays.asList(user1,user2));
	assertThat(actuaList).isEqualTo(user1);
  //assertThat(actualList).containsExactly(user1,user2);
}

}
