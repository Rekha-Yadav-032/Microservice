package com.example.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.User;
//import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.UserServiceImpl;

@RestController
public class UserController {
	@Autowired
	 UserServiceImpl  userServiceImpl;

	//for post the user
	@PostMapping("/addUser")
	public User AddUserData( @RequestBody User user) {
		return	 userServiceImpl.addUserData(user);
		
	}
	// for getting user
	@GetMapping("/getUser")
	public List<User> GetUserData( ) {
		return	 userServiceImpl.getUserData();
		
	}
	//for getting user by id
	@GetMapping("/getUser/{id}")
	public Optional<User> GetUserDataById(@PathVariable int id ) {
		return	 userServiceImpl.getUserDataById(id);
		
	}
	//for updating user
	@PutMapping("/getUser/{id}")
	public ResponseEntity<User> UpdateUserData(@PathVariable int id , @RequestBody User user ) {
		 User updatedUser= userServiceImpl.updateUserData(id, user);
		 if(updatedUser!=null) {
			 
			  return ResponseEntity.ok(updatedUser);
		 }
		 else {
			 return ResponseEntity.notFound().build();
			 
		 }
		
	}
	
	
	//for delete users 
	@DeleteMapping("/getUser/{id}")
	public ResponseEntity<Void> DeleteUserData(@PathVariable int id ) {
		  userServiceImpl.deleteUserDataById(id);

 return ResponseEntity.noContent().build();
	}
	

}
