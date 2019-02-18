package com.info.bloodBank.BloodBank.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.info.bloodBank.BloodBank.entity.User;
import com.info.bloodBank.BloodBank.service.impl.UserServiceImp;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {

	@Autowired
	private UserServiceImp userService;

	@PostMapping(value = "/addUser")
	public ResponseEntity<Object> addUser(@RequestBody User user) {
		User savedUser = (User) userService.addUser(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	@GetMapping(value = "/allUsers")
	public ResponseEntity<List<User>> getAllUser() {
		List<User> allUsers = userService.getAllUsers();
		if (allUsers.isEmpty()) {
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<User>>(allUsers, HttpStatus.OK);
	}

	@GetMapping(value = "/userById/{userId}")
	public ResponseEntity<Optional<User>> getUserById(@PathVariable("userId") Integer userId) {
		Optional<User> userById = userService.getUserById(userId);
		if (!userById.isPresent()) {
			return new ResponseEntity<Optional<User>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Optional<User>>(userById, HttpStatus.OK);
	}

	@DeleteMapping(value = "/deleteUser/{userId}")
	public ResponseEntity<Optional<User>> deleteUser(@PathVariable(value = "userId") Integer userId) {
		Optional<User> userById = userService.getUserById(userId);
		if (!userById.isPresent()) {
			return new ResponseEntity<Optional<User>>(HttpStatus.NOT_FOUND);
		}
		userService.deleteUser(userId);
		return new ResponseEntity<Optional<User>>(HttpStatus.OK);
	}

	@DeleteMapping(value = "/deleteAllUsers")
	public ResponseEntity<User> deleteAllUser() {
		userService.deleteAllUser();
		return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	}

	@PutMapping(value = "/updateUser/{userId}")
	public ResponseEntity<Optional<User>> updateUser(@PathVariable(value = "userId") Integer userId,
			@RequestBody User updatedUser) {
		Optional<User> userById = userService.getUserById(userId);
		if (!userById.isPresent()) {
			return new ResponseEntity<Optional<User>>(HttpStatus.NOT_FOUND);
		}
		userService.updateUser(userId, updatedUser);
		return new ResponseEntity<Optional<User>>(HttpStatus.OK);
	}
}
