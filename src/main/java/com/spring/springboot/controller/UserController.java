package com.spring.springboot.controller;

import com.spring.springboot.entity.User;
import com.spring.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

//    @GetMapping("/{id}")
//    public User getUser(@PathVariable Long id) {
//        return userService.getUser(id);
//    }

    @GetMapping("/{userName}")
    public User getUser(@PathVariable String userName) {
        return userService.findByUserName(userName);
    }

}
