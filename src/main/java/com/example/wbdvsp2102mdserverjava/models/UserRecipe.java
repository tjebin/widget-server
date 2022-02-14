package com.example.wbdvsp2102mdserverjava.models;

import com.example.wbdvsp2102mdserverjava.UserRecipeSequenceIdGenerator;
import javax.persistence.Column;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="user_recipes")
public class UserRecipe {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "recipe_seq")
  @GenericGenerator(
          name = "recipe_seq",
          strategy = "com.example.wbdvsp2102mdserverjava.UserRecipeSequenceIdGenerator",
          parameters = {
                  @Parameter(name = UserRecipeSequenceIdGenerator.INCREMENT_PARAM, value = "50"),
                  @Parameter(name = UserRecipeSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "hero_"),
                  @Parameter(name = UserRecipeSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
  private String recipeID;
  private Integer userID;
  private String recipeName;

  @Column(columnDefinition = "TEXT")
  private String recipeDescription;

  private Integer servings;
  private String cookTime;
  private String cuisine;
  private String tags;
  private String contains;

  @Column(columnDefinition = "TEXT")
  private String ingredients;

  @Column(columnDefinition = "TEXT")
  private String instructions;

  @Column(columnDefinition = "TEXT")
  private String picURL;

  public String getPicURL() {
    return picURL;
  }

  public void setPicURL(String picURL) {
    this.picURL = picURL;
  }

  public String getRecipeID() {
    return recipeID;
  }

  public void setRecipeID(String recipeID) {
    this.recipeID = recipeID;
  }

  public Integer getUserID() {
    return userID;
  }

  public void setUserID(Integer userID) {
    this.userID = userID;
  }

  public String getRecipeName() {
    return recipeName;
  }

  public void setRecipeName(String recipeName) {
    this.recipeName = recipeName;
  }

  public String getRecipeDescription() {
    return recipeDescription;
  }

  public void setRecipeDescription(String recipeDescription) {
    this.recipeDescription = recipeDescription;
  }

  public Integer getServings() {
    return servings;
  }

  public void setServings(Integer servings) {
    this.servings = servings;
  }

  public String getCookTime() {
    return cookTime;
  }

  public void setCookTime(String cookTime) {
    this.cookTime = cookTime;
  }

  public String getCuisine() {
    return cuisine;
  }

  public void setCuisine(String cuisine) {
    this.cuisine = cuisine;
  }

  public String getTags() {
    return tags;
  }

  public void setTags(String tags) {
    this.tags = tags;
  }

  public String getContains() {
    return contains;
  }

  public void setContains(String contains) {
    this.contains = contains;
  }

  public String getIngredients() {
    return ingredients;
  }

  public void setIngredients(String ingredients) {
    this.ingredients = ingredients;
  }

  public String getInstructions() {
    return instructions;
  }

  public void setInstructions(String instructions) {
    this.instructions = instructions;
  }

  public UserRecipe(String recipeID, Integer userID, String recipeName,
                    String recipeDescription, Integer servings, String cookTime, String cuisine,
                    String tags, String contains, String ingredients, String instructions, String picURL) {
    this.recipeID = recipeID;
    this.userID = userID;
    this.recipeName = recipeName;
    this.recipeDescription = recipeDescription;
    this.servings = servings;
    this.cookTime = cookTime;
    this.cuisine = cuisine;
    this.tags = tags;
    this.contains = contains;
    this.ingredients = ingredients;
    this.instructions = instructions;
    this.picURL = picURL;
  }

  public UserRecipe() {}
}

