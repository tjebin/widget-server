package com.example.wbdvsp2102mdserverjava.controllers;

import com.example.wbdvsp2102mdserverjava.models.FollowList;

import com.example.wbdvsp2102mdserverjava.services.FollowListService;


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


@RestController
//@CrossOrigin(origins = "*")
@CrossOrigin(origins = "http://recipehero-2021.herokuapp.com", allowCredentials = "true")
//@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class FollowListController {

    @Autowired
    FollowListService service;

    @PostMapping("/api/followlist")
    public FollowList createFollowList(
            @RequestBody FollowList list
    ) {
        return service.createFollowList(list);
    }

    @GetMapping("/api/followlist")
    public List<FollowList> findAllFollowList() {
        return service.findAllFollowList();
    }

    @GetMapping("/api/followlist/{uid}")
    public FollowList findFollowListById(
            @PathVariable("uid") Integer id
    ) {
        return service.findFollowListById(id);
    }

    @DeleteMapping("/api/followlist/{uid}")
    public Integer deleteFollowList(
            @PathVariable("uid") Integer id) {
        return service.deleteFollowList(id);
    }

    @PutMapping("/api/followlist/{uid}")
    public Integer updateFollowList(
            @PathVariable("uid") Integer id,
            @RequestBody FollowList list) {
        return service.updateFollowList(id, list);
    }

}
