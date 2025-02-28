package com.example.demo.RepositoryTest;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.UserServiceImpl;



@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class UserRepositoryTest {
	
	@Mock
	UserRepository userRepository;
	@InjectMocks
    private UserServiceImpl userServiceImpl;
	
	 
	 @Test
	public void SaveUserDataTest() {
		 
		 
		 User mockuser= new User(1,"ram","ashoka","60");
		 
    	 when(userRepository.save(mockuser)).thenReturn(mockuser);	  
    	 
    	 
    	User addedUser =userServiceImpl.addUserData(mockuser);
    	 assertEquals("ram", addedUser.getName());
    
		
	}
//	=================================================================================================
	 @Test
		public void findAllUserDataTest() {
		 User mockuser1= new User(1,"ram","ashoka","60");
		 User mockuser2= new User(1,"ram","ashoka","60");
		 List<User> mockUsers=Arrays.asList(mockuser1, mockuser2);
		 
		 
		 
		 Mockito.when(userRepository.findAll()).thenReturn(mockUsers);
		 List<User> addedUser =userServiceImpl.getUserData();
		 assertEquals("ram", addedUser.get(0).getName());
		 
		 
		 
	 }
	//=================================================================================================

	 @Test
		public void findUserDataByIdTest() {
		 User mockuser= new User(1,"ram","ashoka","60");
		 Mockito.when(userRepository.findById(anyInt())).thenReturn(Optional.of(mockuser));
		 
		    Optional<User>  getedUser=userServiceImpl.getUserDataById(1);
		    assertEquals( "ram", getedUser.get().getName());
		 
		 	 
		 
	 }
	 
}
