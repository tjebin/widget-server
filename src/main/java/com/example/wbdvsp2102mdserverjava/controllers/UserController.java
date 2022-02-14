package com.example.wbdvsp2102mdserverjava.controllers;

import com.example.wbdvsp2102mdserverjava.models.User;
import com.example.wbdvsp2102mdserverjava.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.servlet.http.HttpSession;
//@CrossOrigin(origins = "*")

@RestController
@CrossOrigin(origins = "http://recipehero-2021.herokuapp.com", allowCredentials = "true")
//@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class UserController {
  @Autowired
  UserService service;

  @PostMapping("/api/users")
  public User createUser(
          @RequestBody User user
  ) {
    User existingUser = service.findUserByUsername(user.getUserName());
    if (existingUser == null) {
      return service.createUser(user);
    }
    return null; //--> handle in client
  }

  @GetMapping("/api/users")
  public List<User> findAllUsers() {
    return service.findAllUsers();
  }

  @GetMapping("/api/users/{uid}")
  public User findUserById(
          @PathVariable("uid") Integer id
  ) {
    return service.findUserById(id);
  }

  @GetMapping("/api/users/list/{uid}")
  public List<User> findUserListById(
          @PathVariable("uid") List<Integer> id
  ) {
    return service.findUserListById(id);
  }


  @DeleteMapping("/api/users/{uid}")
  public Integer deleteUser(
          @PathVariable("uid") Integer id) {
    return service.deleteUser(id);
  }

  @PutMapping("/api/users/{uid}")
  public Integer updateUser(
          @PathVariable("uid") Integer id,
          @RequestBody User user) {
    return service.updateUser(id, user);
  }
}
