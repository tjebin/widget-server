package com.example.wbdvsp2102mdserverjava.repositories;

import com.example.wbdvsp2102mdserverjava.models.FollowList;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;



public interface FollowListRepository
        extends CrudRepository<FollowList, Integer> {

    @Query(value = "SELECT * FROM Followers WHERE userID=:uid", nativeQuery = true)
    public FollowList findFollowListById(@Param("uid")Integer userID);
}
