package com.app.service;

import com.app.entity.User;


public interface UserService {

    User getUser(Long id);

    User findByUserName(String username);

}
