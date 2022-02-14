package com.example.wbdvsp2102mdserverjava.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Followers")
public class FollowList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userID;
    private String userFollowing;
    private String userFollowed;

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }


    public List<Integer> getUserFollowing() {
        List<Integer> userFollowingList = new ArrayList<Integer>();
        String[] userIdString;
        if (this.userFollowing != null) {
            userIdString = this.userFollowing.split(",");
            for (String eachId: userIdString) {
                System.out.println(eachId);
                try {
                    userFollowingList.add((Integer.valueOf(eachId)));
                } catch (NumberFormatException e) {

                }
            }
        }
        return userFollowingList;
    }

    public void setUserFollowing(List<Integer> userFollowing) {
        List<String> userFollowingList = new ArrayList<String>();
        for (Integer eachUserId : userFollowing) {
            userFollowingList.add(String.valueOf(eachUserId));
        }
        this.userFollowing = String.join(",", userFollowingList);

    }

    public List<Integer> getUserFollowed() {
        List<Integer> userFollowedList = new ArrayList<Integer>();
        String[] userIdString;
        if (this.userFollowed != null) {
            userIdString = this.userFollowed.split(",");
            for (String eachId : userIdString) {
                try {
                    userFollowedList.add((Integer.valueOf(eachId)));
                } catch (NumberFormatException e) {

                }
            }
        }
        return userFollowedList;
    }

    public void setUserFollowed(List<Integer> userFollowed) {
        List<String> userFollowedList = new ArrayList<String>();
        for (Integer eachUserId : userFollowed) {
            userFollowedList.add(String.valueOf(eachUserId));
        }
        this.userFollowed = String.join(",", userFollowedList);

    }
}
