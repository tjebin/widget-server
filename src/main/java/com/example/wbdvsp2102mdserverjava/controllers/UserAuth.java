package com.example.wbdvsp2102mdserverjava.controllers;

import com.example.wbdvsp2102mdserverjava.models.User;
import com.example.wbdvsp2102mdserverjava.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


@RestController
@CrossOrigin(origins = "http://recipehero-2021.herokuapp.com", allowCredentials = "true")
//@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class UserAuth {
    @Autowired
    UserService service;


    @PostMapping("/api/users/register")
    public User register(@RequestBody User user,
                         HttpSession session) {
        session.setAttribute("profile", user);
        User newUser = service.createUser(user);
        return newUser;
    }


    @PostMapping("/api/users/profile")
    public User profile(HttpSession session) {
        return (User) session.getAttribute("profile");
    }

    @PostMapping("/api/users/logout")
    public void logout(
            HttpSession session) {
        session.invalidate();
    }


    @PostMapping("/api/users/login")
    public User login(
            @RequestBody User credentials,
            HttpSession session) {

        User currentUser = service.findUserByCredentials(credentials.getUserName(), credentials.getUserPW());
        if (currentUser != null) {
            session.setAttribute("profile", currentUser);
            return currentUser;
        } return null;
    }

    @GetMapping("/api/session/set/{attr}/{value}")
    public String setSessionAttribute(
            @PathVariable("attr") String attr,
            @PathVariable("value") String value,
            HttpSession session) {
        session.setAttribute(attr, value);
        return attr + " = " + value;
    }

    @GetMapping("/api/session/get/{attr}")
    public String getSessionAttribute(
            @PathVariable("attr") String attr,
            HttpSession session) {
        return (String) session.getAttribute(attr);
    }

}
