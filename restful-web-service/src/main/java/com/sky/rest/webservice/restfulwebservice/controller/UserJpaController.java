package com.sky.rest.webservice.restfulwebservice.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sky.rest.webservice.restfulwebservice.Dao.UserRepository;
import com.sky.rest.webservice.restfulwebservice.exception.UserNotFoundException;
import com.sky.rest.webservice.restfulwebservice.model.Post;
import com.sky.rest.webservice.restfulwebservice.model.User;

/**
 * @author SUSHIL
 *
 */
@RestController
public class UserJpaController {

  @Autowired
  UserRepository userRepository;

  @GetMapping(value = "jpa/users", produces = {"application/json"})
  @ResponseBody
  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  @PostMapping(value = "jpa/users", consumes = {"application/json"})
  @ResponseBody
  public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
    User savedUser = userRepository.save(user);
    URI localtion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
        .buildAndExpand(savedUser.getId() - 1).toUri();
    return ResponseEntity.created(localtion).build();

  }

  @GetMapping("jpa/users/{id}")
  @ResponseBody
  public User getUser(@PathVariable int id) {
    Optional<User> user = userRepository.findById(id);
    if (!user.isPresent()) {
      throw new UserNotFoundException("user is not present with this id");
    }
    return user.get();
  }

  @DeleteMapping("jpa/users/delete/{id}")
  @ResponseBody
  public void deletetUser(@PathVariable int id) {
    userRepository.deleteById(id);
  }
  @GetMapping("jpa/user/{id}/posts")
  public List<Post> getAllPost(@PathVariable int id){
    Optional<User> user = userRepository.findById(id);
    if (!user.isPresent()) {
      throw new UserNotFoundException("user is not present with this id");
    }
    return user.get().getPost();
  }

}
