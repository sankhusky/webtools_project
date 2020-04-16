package com.sanket.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sanket.project.model.User;
import com.sanket.project.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//get all users
	@GetMapping("/api/users")
	public ResponseEntity<List<User>> list(){
		List<User> list = userService.getAllUsers();
		return ResponseEntity.ok().body(list);		
	}
	
	//store a new user
	@PostMapping("/api/users")
	public ResponseEntity<?> store(@RequestBody User user){
		int id = userService.storeUser(user);
		return ResponseEntity.ok().body("User created with id:"+id);
		
	}
	
	//get a single user
	@GetMapping("/api/users/{userId}")
	public ResponseEntity<?> get(@PathVariable("userId") int userId){
		User user = userService.getUser(userId);
		return ResponseEntity.ok().body(user);
	}

	//upadting a user
	@PutMapping("/api/users/{userId}")
	public ResponseEntity<?> updateUser(@PathVariable("userId") int userId, @RequestBody User user){
		userService.updateUser(userId, user);
		return ResponseEntity.ok().body("The user has been updated");
	}
	
	//delete a user
	@DeleteMapping("/api/users/{userId}")
	public ResponseEntity<?> deleteUser(@PathVariable("userId") int userId){
		userService.deleteUser(userId);
		return ResponseEntity.ok().body("The user has been deleted");
	}
}
