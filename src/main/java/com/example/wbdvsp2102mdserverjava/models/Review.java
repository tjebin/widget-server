package com.example.wbdvsp2102mdserverjava.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.persistence.criteria.CriteriaBuilder.In;

@Entity
@Table(name="Reviews")
public class Review {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer reviewID;
  private Integer userID;
  private String recipeID;
  private String rating;
  private String reviewText;
  private String recipeName;
  private String reviewTitle;
  private String reviewer;

  public String getRecipeName() {
    return  this.recipeName;
  }

  public void setRecipeName(String recipeName) {
    this.recipeName = recipeName;
  }

  public Integer getReviewID() {
    return reviewID;
  }

  public void setReviewID(Integer reviewID) {
    this.reviewID = reviewID;
  }

  public Integer getUserID() {
    return userID;
  }

  public void setUserID(Integer userID) {
    this.userID = userID;
  }

  public String getRecipeID() {
    return recipeID;
  }

  public void setRecipeID(String recipeID) {
    this.recipeID = recipeID;
  }

  public String getRating() {
    return this.rating;
  }

  public void setRating(String rating) {
    this.rating = rating;
  }

  public String getReviewText() {
    return reviewText;
  }

  public void setReviewText(String reviewText) {
    this.reviewText = reviewText;
  }

  public void setReviewTitle(String reviewTitle) {this.reviewTitle = reviewTitle; }

  public String getReviewTitle() {return reviewTitle; }

  public void setReviewer(String reviewer) {
    this.reviewer = reviewer;
  }

  public String getReviewer() {
    return reviewer;
  }

  public Review(Integer reviewID, Integer userID, String recipeID, String rating,
                String reviewText, String reviewTitle, String reviewer) {
    this.reviewID = reviewID;
    this.userID = userID;
    this.recipeID = recipeID;
    this.rating = rating;
    this.reviewText = reviewText;
    this.reviewTitle = reviewTitle;
    this.reviewer = reviewer;
  }

  public Review () {

  }

}
