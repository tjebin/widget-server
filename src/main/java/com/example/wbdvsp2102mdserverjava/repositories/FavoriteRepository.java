package com.example.wbdvsp2102mdserverjava.repositories;

import com.example.wbdvsp2102mdserverjava.models.Favorite;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FavoriteRepository extends CrudRepository<Favorite, Integer> {
  @Query(value = "SELECT COUNT(userid) FROM favorites WHERE recipe_id=:rid", nativeQuery = true)
  public List<Favorite> findFavsByRecipe(@Param("rid")String recipeID);

  @Query(value = "SELECT recipeid FROM favorites WHERE user_id=:uid", nativeQuery = true)
  public List<Integer> findFavoritesByUser(@Param("uid")Integer userID);

}
