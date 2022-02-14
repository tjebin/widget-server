package com.example.wbdvsp2102mdserverjava.repositories;

import com.example.wbdvsp2102mdserverjava.models.User;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface UserRepository
        extends CrudRepository<User, Integer> {

  @Query(value = "SELECT * FROM users WHERE userID=:uid", nativeQuery = true)
  public User findUserById(@Param("uid")Integer userID);

  @Query(value = "SELECT * FROM users WHERE userID IN :uid", nativeQuery = true)
  public List<User> findUserListById(@Param("uid")List<Integer> idList);

  //UserAuth updates start here:
  @Query(value = "SELECT * FROM Users WHERE user_name=:username", nativeQuery = true)
  public User findUserByUsername(@Param("username") String username);

  //change to FROM User user if issues
  @Query(value = "SELECT * FROM Users WHERE user_name=:username and userPW=:password", nativeQuery = true)
  public User findUserByCredentials(@Param("username") String username, @Param("password") String password);


}

