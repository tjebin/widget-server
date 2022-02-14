package com.example.wbdvsp2102mdserverjava.repositories;

import com.example.wbdvsp2102mdserverjava.models.Review;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ReviewRepository
        extends CrudRepository<Review, Integer> {

  @Query(value = "SELECT * reviews WHERE recipeID=:rid", nativeQuery = true)
  public List<Review> findReviewsForRecipe(@Param("rid")String recipeID);

  @Query(value = "SELECT AVG(rating) FROM reviews WHERE recipeID=:rid", nativeQuery = true)
  public List<Review> findAvgRatingForRecipe(@Param("rid")String recipeID);

  @Query(value = "SELECT * FROM reviews WHERE userID=:uid", nativeQuery = true)
  public List<Review> findReviewByUserId(@Param("uid")Integer userID);

}


