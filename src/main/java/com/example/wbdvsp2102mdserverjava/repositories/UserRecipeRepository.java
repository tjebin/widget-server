package com.example.wbdvsp2102mdserverjava.repositories;

import com.example.wbdvsp2102mdserverjava.models.UserRecipe;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface UserRecipeRepository
        extends CrudRepository<UserRecipe, String> {

  @Query(value = "SELECT * FROM user_recipes WHERE recipeID=:rid", nativeQuery = true)
  public List<UserRecipe> findRecipeById(@Param("rid")String recipeId);

  @Query(value = "SELECT * FROM user_recipes WHERE userID=:uid", nativeQuery = true)
  public List<UserRecipe> findRecipeByUserId(@Param("uid")Integer userID);

}

