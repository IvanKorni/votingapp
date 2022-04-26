package com.spring.springboot.service;

import com.spring.springboot.entity.User;


public interface UserService {

    User getUser(Long id);

    User findByUserName(String username);

}
