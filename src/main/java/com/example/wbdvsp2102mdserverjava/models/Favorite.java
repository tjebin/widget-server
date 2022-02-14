package com.example.wbdvsp2102mdserverjava.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Favorites")
public class Favorite {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer favoriteId;
  private String recipeId;
  private Integer userId;
  private String recipeName;
  private String recipePhotoUrl;

  public String getRecipeName() {
    return recipeName;
  }

  public void setRecipeName(String recipeName) {
    this.recipeName = recipeName;
  }

  public String getRecipePhotoUrl() {
    return recipePhotoUrl;
  }

  public void setRecipePhotoUrl(String recipePhotoUrl) {
    this.recipePhotoUrl = recipePhotoUrl;
  }

  public Integer getFavoriteId() {
    return favoriteId;
  }

  public void setFavoriteId(Integer favoriteId) {
    this.favoriteId = favoriteId;
  }

  public String getRecipeId() {
    return recipeId;
  }

  public void setRecipeId(String recipeId) {
    this.recipeId = recipeId;
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public Favorite(Integer favoriteId, String recipeId, Integer userId, String recipeName, String recipePhotoUrl) {
    this.favoriteId = favoriteId;
    this.recipeId = recipeId;
    this.userId = userId;
    this.recipeName = recipeName;
    this.recipePhotoUrl = recipePhotoUrl;
  }

  public Favorite(){}
}