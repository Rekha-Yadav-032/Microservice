package com.example.demo.ApiTest;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.Controller.UserController;
import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.UserService;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class UserAPiTest {
	@Mock
	UserRepository UserRepository;

    @Mock
    private UserService userServiceImpl;
    
	@Autowired
	MockMvc MockMvc;
	
	 @InjectMocks
	 private UserController userController;
	 

	@Test
	public void postUserData()throws Exception  {
		 User mockuser= new User(1,"ram","ashoka","60");
		 Mockito.when(userServiceImpl.addUserData(any(User.class))).thenReturn(mockuser);
		
		 
		 MockMvc.perform(post("/addUser")
				 .contentType("application/json")
				 .content("{\"name\":\"ram\", \"house\":\"ashoka\", \"marks\":\"60\"}"))
		         .andExpect(status().isOk())
	             .andExpect(jsonPath("$.name").value("ram"))
	             .andExpect(jsonPath("$.house").value("ashoka")) 
	              .andExpect(jsonPath("$.marks").value("60")); 	
		
	}

}
