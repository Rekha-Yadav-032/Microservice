package com.example.demo.ServiceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyLong;

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

import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepository;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
	@Mock
	UserRepository UserRepository;
	@InjectMocks
	com.example.demo.Service.UserServiceImpl UserServiceImpl;
	
	
	@Test
	public void addUserDataTest() {
		
		User mockUser= new User();
		mockUser.setId(2);
		mockUser.setName("ram");
		mockUser.setHouse("neelgriri");
		mockUser.setMarks("70");
		
		
		Mockito.when(UserRepository.save(mockUser)).thenReturn(mockUser);
		  User addedUser =UserServiceImpl .addUserData(mockUser);
		  assertEquals(mockUser.getName(), addedUser.getName());		
		
	}
	//================================================================================================

	@Test
	public void getUserDataTest() {
		   User mockuser1 = new User(1, "Ram", "Neelgiri", "70");
	        User mockuser2 = new User(2, "Shyam", "Nilachal", "85");
	       List<User> mockUsers = Arrays.asList(mockuser1, mockuser2);
	
		
		Mockito.when(UserRepository.findAll()).thenReturn(mockUsers );
		
	       List<User> getmockUsers =  UserServiceImpl.getUserData();
	       assertEquals(2, getmockUsers .size());
       assertEquals("Ram",  getmockUsers.get(0).getName());		
		
		
		
		
		
	}
	//================================================================================================
	
	
	@Test
	public void getUserByIdTest() {
		User mockUser = new User(1, "Ram", "Neelgiri", "70");

		Mockito.when(UserRepository.findById(anyInt())).thenReturn(Optional.of(mockUser));

       
	        Optional<User> retrievedUser = UserServiceImpl.getUserDataById(1);
       assertEquals("Ram", retrievedUser.get().getName());     
		
		
	}
	
	
	//================================================================================================

	
}
	
	
	
	
	
