package com.example.wbdvsp2102mdserverjava.controllers;

import com.example.wbdvsp2102mdserverjava.models.Favorite;
import com.example.wbdvsp2102mdserverjava.services.FavoriteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
//@CrossOrigin(origins = "*")
@CrossOrigin(origins = "http://recipehero-2021.herokuapp.com", allowCredentials = "true")
//@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class FavoriteController {
  @Autowired
  FavoriteService service;

  @PostMapping("/api/favorites")
  public Favorite createFavorite(
          @RequestBody Favorite favorite
  ) {
    return service.createFavorite(favorite);
  }

  @GetMapping("/api/favorites")
  public List<Favorite> findAllFavorites() {
    return service.findAllFavorites();
  }

  @DeleteMapping("/api/favorites/{fid}")
  public Integer deleteFavorite(
          @PathVariable("fid") Integer favoriteID
  ) {
    return service.deleteFavorite(favoriteID);
  }

}
