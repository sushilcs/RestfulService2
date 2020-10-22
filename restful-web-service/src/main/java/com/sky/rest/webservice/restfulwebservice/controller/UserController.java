package com.sky.rest.webservice.restfulwebservice.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sky.rest.webservice.restfulwebservice.Dao.UserDao;
import com.sky.rest.webservice.restfulwebservice.exception.UserDeleteException;
import com.sky.rest.webservice.restfulwebservice.exception.UserNotFoundException;
import com.sky.rest.webservice.restfulwebservice.model.User;

@Controller
public class UserController {
	@Autowired
	UserDao udao;

	@GetMapping("/users")
	@ResponseBody
	public List<User> getAllUsers() {
		return udao.getAllUsers();
	}

	@PostMapping(value="/users",consumes= {"application/xml","application/json"})
	@ResponseBody
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser = udao.save(user);
		URI localtion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedUser.getId() - 1).toUri();
		return ResponseEntity.created(localtion).build();

	}

	@GetMapping("/users/{id}")
	@ResponseBody
	public User getUser(@PathVariable int id) {
		User user = udao.getOne(id);
		if (user == null) {
			throw new UserNotFoundException("User with userid-" + id + " not found");
		}
		return user;
	}

	@GetMapping("/users/delete/{id}")
	@ResponseBody
	public void deletetUser(@PathVariable int id) {
		User user = udao.deleteUserById(id);
		if (user == null) {
			throw new UserDeleteException("User with userid-" + id + " not found");
		}
	}
}
