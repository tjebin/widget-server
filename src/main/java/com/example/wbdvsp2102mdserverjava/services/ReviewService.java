package com.example.wbdvsp2102mdserverjava.services;

import com.example.wbdvsp2102mdserverjava.models.Review;
import com.example.wbdvsp2102mdserverjava.repositories.ReviewRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

  @Autowired
  ReviewRepository repository;

  public Review createReviewForRecipe(String recipeID, Review review) {
    review.setRecipeID(recipeID);
    return  repository.save(review);
  }

  public List<Review> findAllReviews() {
    return (List<Review>) repository.findAll();
  }

  public List<Review> findReviewsForRecipe(String recipeID) {
    return repository.findReviewsForRecipe(recipeID);
  }

  public List<Review> findAvgRatingForRecipe(String recipeID) {
    return repository.findAvgRatingForRecipe(recipeID);
  }

  public List<Review> findReviewByUserId(Integer userID) {
    return repository.findReviewByUserId(userID);
  }

  public Integer deleteReview(Integer reviewID) {
    repository.deleteById(reviewID);
    return 1;
  }

  public Integer updateReview(Integer reviewID, Review review) {

    Review originalReview = repository.findById(reviewID).get();

    if (originalReview == null) {
      return 0;
    }
    if (review.getReviewID() != null) {
      originalReview.setReviewID(review.getReviewID());
    }
    if (review.getRecipeID() != null) {
      originalReview.setRecipeID(review.getRecipeID());
    }
    if (review.getRating() != null) {
      originalReview.setRating(review.getRating());
    }
    if (review.getReviewText() != null) {
      originalReview.setReviewText(review.getReviewText());
    }

    repository.save(originalReview);
    return 1;

  }
}
