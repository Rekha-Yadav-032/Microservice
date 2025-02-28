package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;

	@Override
	public User addUserData( User user) {
		
		
	
		return userRepository.save(user);
	}

	public List<User> getUserData() {
		return userRepository.findAll();
	}

	public Optional<User> getUserDataById(int id) {
		
		return userRepository.findById(id);
	}

	@Override
	public User updateUserData(int id, User newuser) {
		
	User userData= userRepository.findById(id).orElse(null);
	if(userData !=null) {
		 return userRepository.save(newuser);
		
	}
	return null;
	
	}

	@Override
	public void deleteUserDataById(int id) {
		// TODO Auto-generated method stub
		
		  userRepository.deleteById(id);
	}

}
