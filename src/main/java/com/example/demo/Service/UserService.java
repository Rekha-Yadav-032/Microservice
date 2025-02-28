package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import com.example.demo.Entity.User;

public interface UserService {
	public User addUserData(User user);
	public List<User> getUserData();
	public Optional<User> getUserDataById(int id);
	public User updateUserData(int id,User user);
	public void deleteUserDataById(int id);

}
