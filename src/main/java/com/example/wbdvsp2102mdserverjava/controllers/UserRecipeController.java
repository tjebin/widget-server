package com.example.wbdvsp2102mdserverjava.controllers;

import com.example.wbdvsp2102mdserverjava.models.UserRecipe;
import com.example.wbdvsp2102mdserverjava.services.UserRecipeService;

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


@RestController
@CrossOrigin(origins = "http://recipehero-2021.herokuapp.com", allowCredentials = "true")
//@CrossOrigin(origins = "*")
public class UserRecipeController {
  @Autowired
  UserRecipeService service;

  @PostMapping("/api/userrecipes")
  public UserRecipe createUserRecipe(
          @RequestBody UserRecipe userRecipe
  ) {
    return service.createUserRecipe(userRecipe);
  }

  @GetMapping("/api/userrecipes")
  public List<UserRecipe> findAllUserRecipes() {
    return service.findAllUserRecipes();
  }

  @GetMapping("/api/users/{uid}/userrecipes")
  public List<UserRecipe> findUserRecipeByUserId(
          @PathVariable("uid") Integer userID
  ) {
    return service.fineUserRecipeByUserId(userID);
  }


  @DeleteMapping("/api/userrecipes/{rid}")
  public Integer deleteUserRecipe(
          @PathVariable("rid") String id) {
    return service.deleteUserRecipe(id);
  }

  @PutMapping("/api/userrecipes/{rid}")
  public Integer updateUserRecipe(
          @PathVariable("rid") String id,
          @RequestBody UserRecipe userRecipe) {
    return service.updateUserRecipe(id, userRecipe);
  }
}
