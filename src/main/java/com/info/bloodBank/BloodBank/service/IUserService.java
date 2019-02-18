package com.info.bloodBank.BloodBank.service;

import java.util.List;
import java.util.Optional;

import com.info.bloodBank.BloodBank.entity.User;

public interface IUserService {
	public User addUser(User user);

	public List<User> getAllUsers();

	public Optional<User> getUserById(Integer userId);

	public void deleteUser(Integer userId);

	public void deleteAllUser();

	public void updateUser(Integer userId, User user);
}
