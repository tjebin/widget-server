package com.example.wbdvsp2102mdserverjava.services;

import com.example.wbdvsp2102mdserverjava.models.User;
import com.example.wbdvsp2102mdserverjava.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.servlet.http.HttpSession;


@Service
public class UserService {

  @Autowired
  UserRepository repository;

  public User createUser(User user) {

    return repository.save(user);
  }

  public List<User> findAllUsers() {

    return (List<User>) repository.findAll();
  }

  public User findUserById(Integer userID) {

    return repository.findUserById(userID);
  }

  public List<User> findUserListById(List<Integer> userID) {
    return repository.findUserListById(userID);
  }

  public Integer deleteUser(Integer userID) {
    repository.deleteById(userID);
    return 1;
  }

  public Integer updateUser(Integer userID, User user) {

    User originalUser = repository.findById(userID).get();

    if (originalUser == null) {
      return 0;
    }
    if (user.getUserID() != null) {
      originalUser.setUserID(user.getUserID());
    }
    if (user.getUserName() != null) {
      originalUser.setUserName(user.getUserName());
    }
    if (user.getUserPW() != null) {
      originalUser.setUserPW(user.getUserPW());
    }
    if (user.getUserRole() != null) {
      originalUser.setUserRole(user.getUserRole());
    }
    if (user.getUserPicUrl() != null) {
      originalUser.setUserPicUrl(user.getUserPicUrl());
    }
    if (user.getUserPicUrl() != null) {
      originalUser.setUserPicUrl(user.getUserPicUrl());
    }
    if (user.getUserBio() != null) {
      originalUser.setUserBio(user.getUserBio());
    }

    repository.save(originalUser);
    return 1;

  }
  //UserAuth stuff
  public User findUserByUsername(String username) {
    return repository.findUserByUsername(username);
  }

  public User findUserByCredentials(String username, String password) {
    return repository.findUserByCredentials(username, password);
  }

}
