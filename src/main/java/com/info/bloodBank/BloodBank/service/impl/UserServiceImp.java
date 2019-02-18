package com.info.bloodBank.BloodBank.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.info.bloodBank.BloodBank.entity.User;
import com.info.bloodBank.BloodBank.repository.UserRepository;
import com.info.bloodBank.BloodBank.service.IUserService;

@Service
public class UserServiceImp implements IUserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User addUser(User user) {
		User savedUser = userRepository.save(user);
		return savedUser;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> allUsers = userRepository.findAll();
		return allUsers;
	}

	@Override
	public Optional<User> getUserById(Integer userId) {
		Optional<User> userById = userRepository.findById(userId);
		return userById;
	}

	@Override
	public void deleteUser(Integer userId) {
		userRepository.deleteById(userId);
	}

	@Override
	public void deleteAllUser() {
		userRepository.deleteAll();
	}

	@Override
	public void updateUser(Integer userId, User updatedUser) {
		User user = userRepository.getOne(userId);
		user.setId(userId);
		userRepository.save(updatedUser);
	}
}
