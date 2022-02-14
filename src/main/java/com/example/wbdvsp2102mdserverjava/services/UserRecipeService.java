package com.example.wbdvsp2102mdserverjava.services;

import com.example.wbdvsp2102mdserverjava.models.UserRecipe;
import com.example.wbdvsp2102mdserverjava.repositories.UserRecipeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRecipeService {

  @Autowired
  UserRecipeRepository repository;

  public UserRecipe createUserRecipe(UserRecipe userRecipe) {
    return  repository.save(userRecipe);
  }

  public List<UserRecipe> findAllUserRecipes() {
    return (List<UserRecipe>) repository.findAll();
  }

  public List<UserRecipe> fineUserRecipeById(String recipeID) {
    return repository.findRecipeById(recipeID);
  }

  public List<UserRecipe> fineUserRecipeByUserId(Integer userID) {
    return repository.findRecipeByUserId(userID);
  }

  public Integer deleteUserRecipe(String recipeID) {
    repository.deleteById(recipeID);
    return 1;
  }

  public Integer updateUserRecipe(String recipeID, UserRecipe userRecipe) {

    UserRecipe originalUserRecipe = repository.findById(recipeID).get();

    if (originalUserRecipe == null) {
      return 0;
    }
    if (userRecipe.getRecipeID() != null) {
      userRecipe.setRecipeID(userRecipe.getRecipeID());
    }
    if (userRecipe.getUserID() != null) {
      userRecipe.setUserID(userRecipe.getUserID());
    }
    if (userRecipe.getRecipeName() != null) {
      userRecipe.setRecipeName(userRecipe.getRecipeName());
    }
    if (userRecipe.getRecipeDescription() != null) {
      userRecipe.setRecipeDescription(userRecipe.getRecipeDescription());
    }
    if (userRecipe.getServings() != null) {
      userRecipe.setServings(userRecipe.getServings());
    }
    if (userRecipe.getCookTime() != null) {
      userRecipe.setCookTime(userRecipe.getCookTime());
    }
    if (userRecipe.getCuisine() != null) {
      userRecipe.setCuisine(userRecipe.getCuisine());
    }
    if (userRecipe.getTags() != null) {
      userRecipe.setTags(userRecipe.getTags());
    }
    if (userRecipe.getContains() != null) {
      userRecipe.setContains(userRecipe.getContains());
    }
    if (userRecipe.getIngredients() != null) {
      userRecipe.setIngredients(userRecipe.getIngredients());
    }
    if (userRecipe.getInstructions() != null) {
      userRecipe.setInstructions(userRecipe.getInstructions());
    }

    repository.save(originalUserRecipe);
    return 1;

  }
}
