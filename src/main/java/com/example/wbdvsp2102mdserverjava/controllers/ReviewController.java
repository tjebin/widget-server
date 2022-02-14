package com.example.wbdvsp2102mdserverjava.controllers;

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
import com.example.wbdvsp2102mdserverjava.services.ReviewService;
import com.example.wbdvsp2102mdserverjava.models.Review;

@RestController
@CrossOrigin(origins = "http://recipehero-2021.herokuapp.com", allowCredentials = "true")
//@CrossOrigin(origins = "*")
public class ReviewController {
  @Autowired
  ReviewService service;

  @PostMapping("/api/recipe/{rid}/reviews")
  public Review createReviewForRecipe(
          @PathVariable("rid") String recipeID,
          @RequestBody Review review
  ) {
    return service.createReviewForRecipe(recipeID, review);
  }

  @GetMapping("/api/reviews")
  public List<Review> findAllReviews() {
    return service.findAllReviews();
  }

  @GetMapping("/api/recipe/{rid}/reviews")
  public List<Review> findReviewsForRecipe(
          @PathVariable("rid") String recipeID
  ) {
    return service.findReviewsForRecipe(recipeID);
  }

  @GetMapping("/api/recipe/{rid}/reviews/rating")
  public List<Review> findAvgRatingForRecipe(
          @PathVariable("rid") String recipeID
  ) {
    return service.findAvgRatingForRecipe(recipeID);
  }

  @GetMapping("/api/user/{uid}/reviews")
  public List<Review> findReviewsByUser(
          @PathVariable("uid") Integer userID
  ) {
    return service.findReviewByUserId(userID);
  }

  @DeleteMapping("/api/reviews/{rid}")
  public Integer deleteReview(
          @PathVariable("rid") Integer id) {
    return service.deleteReview(id);
  }

  @PutMapping("/api/reviews/{rid}")
  public Integer updateReview(
          @PathVariable("rid") Integer id,
          @RequestBody Review review) {
    return service.updateReview(id, review);
  }
}
