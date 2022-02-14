package com.example.wbdvsp2102mdserverjava.services;

import com.example.wbdvsp2102mdserverjava.models.Favorite;
import com.example.wbdvsp2102mdserverjava.repositories.FavoriteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteService {

  @Autowired
  FavoriteRepository repository;

  public Favorite createFavorite(Favorite favorite) {
    return repository.save(favorite);
  }

  public List<Favorite> findAllFavorites() {
    return (List<Favorite>) repository.findAll();
  }

  public Integer deleteFavorite(Integer favoriteID) {
    repository.deleteById(favoriteID);
    return 1;
  }



}
