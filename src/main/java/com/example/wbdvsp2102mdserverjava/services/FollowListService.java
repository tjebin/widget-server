package com.example.wbdvsp2102mdserverjava.services;

import com.example.wbdvsp2102mdserverjava.models.FollowList;
//import com.example.wbdvsp2102mdserverjava.models.User;
import com.example.wbdvsp2102mdserverjava.repositories.FollowListRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FollowListService {

    @Autowired
    FollowListRepository repository;

    public FollowList createFollowList(FollowList list) {
        return  repository.save(list);
    }

    public List<FollowList> findAllFollowList() {
        return (List<FollowList>) repository.findAll();
    }

    public FollowList findFollowListById(Integer userID) {
        return repository.findFollowListById(userID);
    }

    public Integer deleteFollowList(Integer userID) {
        repository.deleteById(userID);
        return 1;
    }

    public Integer updateFollowList(Integer userID, FollowList list) {

        FollowList originalList = repository.findById(userID).get();

        if (originalList == null) {
            return 0;
        }
        if (list.getUserID() != null) {
            originalList.setUserID(list.getUserID());
        }
        if (originalList.getUserFollowing() != null) {
            originalList.setUserFollowing(list.getUserFollowing());
        }
        if (originalList.getUserFollowed() != null) {
            originalList.setUserFollowed(list.getUserFollowed());
        }


        repository.save(originalList);
        return 1;

    }
}
