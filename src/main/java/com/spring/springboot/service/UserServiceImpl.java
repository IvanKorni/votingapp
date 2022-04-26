package com.spring.springboot.service;

import com.spring.springboot.dao.UserDao;
import com.spring.springboot.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserDao userDao;

    @Override
    public User getUser(Long id) {
        return userDao.getById(id);
    }

    @Override
    public User findByUserName(String username) {
        return userDao.findByUsername(username);
    }

}
